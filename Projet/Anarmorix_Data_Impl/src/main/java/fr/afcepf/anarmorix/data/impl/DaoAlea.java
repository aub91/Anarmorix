package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe Data permettant la gestion des aleas.
 */
@Remote(IDaoAlea.class)
@Stateless
public class DaoAlea implements IDaoAlea {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des lignes d'une {@link Commande}.
     */
    private static final String REQ_RECHERCHE =
            "SELECT l.aleas FROM LigneCommande l WHERE l.id = :pId";

    /**
     * Requête permettant de récupérer une ligne commande en fonction de son Id.
     */
    private static final String REQ_ALEA_ID = "Select a FROM Alea a WHERE a.id = :pId";


    /**
     * Default constructor.
     */
    public DaoAlea() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Alea> rechercher(LigneCommande paramLigne) throws AnarmorixException {
        try {
            List<Alea> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", paramLigne.getId()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("La ligne de commande n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "La ligne de commande n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Alea alea = (Alea) em.createQuery(REQ_ALEA_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(alea);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Alea ajouter(Alea paramAlea) throws AnarmorixException {
        try {
            em.persist(paramAlea);
            return paramAlea;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Alea mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Alea alea = (Alea) em.createQuery(REQ_ALEA_ID).setParameter("pId", paramId).getSingleResult();
            Alea updated = em.merge(alea);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}