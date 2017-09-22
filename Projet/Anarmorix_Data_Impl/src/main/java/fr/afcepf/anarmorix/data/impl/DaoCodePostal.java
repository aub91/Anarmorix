package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Implémentation des fonctionnalités métier liés à l'entité {@link CodePostal}.
 */
@Remote(IDaoCodePostal.class)
@Stateless
public class DaoCodePostal implements IDaoCodePostal {

    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public DaoCodePostal() {
    }

    @Override
    public List<CodePostal> rechercher(String paramCp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CodePostal ajouter(CodePostal paramCodePoostal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CodePostal MettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
        try {
            String hql = "SELECT ad.codePostal FROM Adresse ad WHERE ad.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramAdresse.getId());
            paramAdresse.setCodePostal((CodePostal) queryHql.getSingleResult());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return paramAdresse;
    }

}