package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Recette;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les fonctionnalités de {@link IDaoVille}.
 */
@Remote(IDaoVille.class)
@Stateless
public class DaoVille implements IDaoVille {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver des {@link Ville}s en fonction d'un nom.
     */
    private static final String REQ_RECHERCHE =
            "SELECT v FROM Ville v WHERE v.libelle LIKE :pLibelle";

    /**
     * Requête permettant de récupérer une ville en fonction de son Id.
     */
    private static final String REQ_RECETTE_ID = "SELECT v FROM Ville v WHERE v.id = :pId";

    /**
     * Default constructor.
     */
    public DaoVille() {
    }

    @Override
    public List<Ville> rechercher(String paramLibelle) throws AnarmorixException {
        try {
            List<Ville> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pLibelle", paramLibelle).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("Le libellé n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "Le libellé n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public Ville ajouter(Ville paramVille) throws AnarmorixException {
        try {
            em.persist(paramVille);
            return paramVille;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Ville ville = (Ville) em.createQuery(REQ_RECETTE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(ville);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Ville mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Ville ville = (Ville) em.createQuery(REQ_RECETTE_ID).setParameter("pId", paramId).getSingleResult();
            Ville updated = em.merge(ville);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
        try {
            String hql = "SELECT ad.ville FROM Adresse ad WHERE ad.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramAdresse.getId());
            paramAdresse.setVille((Ville) queryHql.getSingleResult());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return paramAdresse;
    }

}