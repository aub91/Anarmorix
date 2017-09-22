package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les fonctionnalités de {@link IDaoVille}.
 */
@Remote(IDaoVille.class)
@Stateless
public class DaoVille implements IDaoVille {
    /**
     * Entity Manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public DaoVille() {
    }

    @Override
    public List<Ville> rechercher(String paramNom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ville ajouter(Ville paramVille) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ville mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException {
        try {
            String hql = "SELECT ad.ville FROM Adresse ad WHERE ad.id = :paramId";
            Query queryHql = em.createQuery(hql);
            queryHql.setParameter("paramId", paramAdresse.getId());
            paramAdresse.setVille((Ville) queryHql.getSingleResult());
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
        return paramAdresse;
    }

}