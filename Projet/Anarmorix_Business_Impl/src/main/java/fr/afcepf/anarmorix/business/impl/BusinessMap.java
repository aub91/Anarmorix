package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.data.api.IDaoPointRelais;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

@Remote(IBusinessMap.class)
@Stateless
public class BusinessMap implements IBusinessMap {
    /**
     * Classe contenant la méthode à appeler.
     */
    @EJB
    private IDaoPointRelais dao;
    @Override
    public List<PointRelais> getAllPointRelais() throws AnarmorixException {
        List<PointRelais> liste = null;
        try {
            liste = dao.getAll();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }
}
