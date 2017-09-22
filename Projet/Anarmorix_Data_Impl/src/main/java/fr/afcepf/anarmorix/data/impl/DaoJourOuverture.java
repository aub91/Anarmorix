package fr.afcepf.anarmorix.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * Implémentation des fonctionnalités métier liés à l'entité {@link JourOuverture}.
 * @author Aubin
 *
 */
@Remote(IDaoJourOuverture.class)
@Stateless
public class DaoJourOuverture implements IDaoJourOuverture {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    @SuppressWarnings("unchecked")
    @Override
    public PointRelais getAllByPointRelais(PointRelais paramPointRelais) throws AnarmorixException {
        try {
            String hql = "SELECT pr.joursOuverture FROM PointRelais pr WHERE pr.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramPointRelais.getId());
            paramPointRelais.setJoursOuverture(queryHql.getResultList());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return paramPointRelais;
    }
    /**
     * Default constructor.
     */
    public DaoJourOuverture() {
    }

}
