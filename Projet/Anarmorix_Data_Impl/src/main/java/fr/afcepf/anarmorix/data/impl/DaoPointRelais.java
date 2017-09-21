package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;
/**
 * Fonctionnalités liées à l'entité {@link PointRelais}.
 * @author Aubin
 *
 */
@Remote(IDaoPointRelais.class)
@Stateless
public class DaoPointRelais implements IDaoPointRelais {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    @SuppressWarnings("unchecked")
    @Override
    public List<PointRelais> getAll() throws AnarmorixException {
        List<PointRelais> liste = null;
        try {
            String hql = "SELECT pr FROM PointRelais pr";
            Query queryHql = em.createQuery(hql);
            liste = queryHql.getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }


}
