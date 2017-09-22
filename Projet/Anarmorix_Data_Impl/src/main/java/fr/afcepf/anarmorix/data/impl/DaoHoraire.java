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
     * Default constructor.
     */
    public DaoHoraire() {
    }

    @Override
    public Horaire ajouter(Horaire paramHoraire) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Horaire mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
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