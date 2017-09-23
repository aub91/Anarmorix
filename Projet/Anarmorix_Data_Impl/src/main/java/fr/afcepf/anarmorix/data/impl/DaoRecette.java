package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoRecette;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.entity.Recette;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthodes de l'{@link IDaoRecette}.
 */
@Remote(IDaoRecette.class)
@Stateless
public class DaoRecette implements IDaoRecette {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver des {@link Recette}s en fonction d'un nom.
     */
    private static final String REQ_RECHERCHE =
            "SELECT r FROM Recette r WHERE r.libelle LIKE :pLibelle";

    /**
     * Requête permettant de récupérer une recette en fonction de son Id.
     */
    private static final String REQ_RECETTE_ID = "SELECT r FROM Recette r WHERE r.id = :pId";

    /**
     * Default constructor.
     */
    public DaoRecette() {
    }

    @Override
    public List<Recette> rechercher(String paramLibelle)  throws AnarmorixException{
        try {
            List<Recette> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pLibelle", paramLibelle).getResultList();
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
    public Recette ajouter(Recette paramRecette) throws AnarmorixException {
        try {
            em.persist(paramRecette);
            return paramRecette;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Recette recette = (Recette) em.createQuery(REQ_RECETTE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(recette);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Recette mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Recette recette = (Recette) em.createQuery(REQ_RECETTE_ID).setParameter("pId", paramId).getSingleResult();
            Recette updated = em.merge(recette);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}