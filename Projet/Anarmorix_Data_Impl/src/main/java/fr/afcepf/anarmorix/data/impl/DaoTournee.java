package fr.afcepf.anarmorix.data.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthode de persistence de {@link IDaoTournee}.
 */
public class DaoTournee implements IDaoTournee {

    /**
     * Default constructor.
     */
    public DaoTournee() {
    }
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    @Override
    public Tournee ajouter(Tournee paramTournee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Tournee mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tournee> rechercherBySocieteDeLivraison(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException {
        List<Tournee> liste = null;
        try {
            String hql = "SELECT sd.tournee FROM SocieteDeLivraison sd JOIN FETCH sd.lignesCmd WHERE sd.id = :paramId";
            Query queryHql = em.createQuery(hql).setParameter("paramId", paramSocieteDeLivraison.getId());
            liste = queryHql.getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }

}