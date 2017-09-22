package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Implémentation des fonctionnalités métier liés à l'entité {@link Adresse}.
 */
@Remote(IDaoAdresse.class)
@Stateless
public class DaoAdresse implements IDaoAdresse {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public DaoAdresse() {
    }

    @Override
    public List<Ville> rechercher(Integer paramNumero, String paramVoie) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse ajouter(Adresse paramAdresse) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Commerce getByCommerce(Commerce paramCommerce) throws AnarmorixException {
        try {
            String hql = "SELECT c.adresse FROM Commerce c WHERE c.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramCommerce.getId());
            paramCommerce.setAdresse((Adresse) queryHql.getSingleResult());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return paramCommerce;
    }

}