package fr.afcepf.anarmorix.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Implémentation des fonctionnalités métier liés à l'entité {@link Horaire}.
 */
@Remote(IDaoHoraire.class)
@Stateless
public class DaoHoraire implements IDaoHoraire {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_HORAIRE_ID = "Select h FROM Horaire c WHERE h.id = :pId";

    /**
     * Default constructor.
     */
    public DaoHoraire() {
    }

    @Override
    public Horaire ajouter(Horaire paramHoraire) throws AnarmorixException {
        try {
            em.persist(paramHoraire);
            return paramHoraire;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            Horaire horaire = (Horaire) em.createQuery(REQ_HORAIRE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(horaire);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Horaire mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            Horaire horaire = (Horaire) em.createQuery(REQ_HORAIRE_ID).setParameter("pId", paramId).getSingleResult();
            Horaire updated = em.merge(horaire);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public JourOuverture getHoraireByJourOuverture(JourOuverture paramJourOuverture) throws AnarmorixException {
        try {
            String hql = "SELECT jo.horairesOuverture FROM JourOuverture jo WHERE jo.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramJourOuverture.getId());
            paramJourOuverture.setHorairesOuverture(queryHql.getResultList());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return paramJourOuverture;
    }

}