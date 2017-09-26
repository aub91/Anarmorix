package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoMotifDesinscription;
import fr.afcepf.anarmorix.entity.MotifDesinscription;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthides de l'{@link IDaoMotifDesinscription}.
 */
@Remote(IDaoMotifDesinscription.class)
@Stateless
public class DaoMotifDesinscription implements IDaoMotifDesinscription {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE =
            "SELECT m FROM MotifDesinscription";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_MOTIF_ID = "Select m FROM MotifDesinscription c WHERE m.id = :pId";

    /**
     * Default constructor.
     */
    public DaoMotifDesinscription() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MotifDesinscription> rechercher() throws AnarmorixException {
        try {
            List<MotifDesinscription> liste =  em.createQuery(REQ_RECHERCHE).getResultList();
            return liste;
        } catch (Exception e) {
             AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
             throw exc;
        }
    }

    @Override
    public MotifDesinscription ajouter(MotifDesinscription paramMotif) throws AnarmorixException {
        try {
            em.persist(paramMotif);
            return paramMotif;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            MotifDesinscription motif = (MotifDesinscription) em.createQuery(REQ_MOTIF_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(motif);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public MotifDesinscription mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            MotifDesinscription motif = (MotifDesinscription) em.createQuery(REQ_MOTIF_ID).setParameter("pId", paramId).getSingleResult();
            MotifDesinscription updated = em.merge(motif);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}