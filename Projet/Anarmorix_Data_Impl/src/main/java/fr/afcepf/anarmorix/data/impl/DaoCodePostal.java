package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.anarmorix.data.api.IDaoCodePostal;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Ville;
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
     * Requête permettant de trouver l'ensemble des {@link Catalogue}s d'une exploitation.
     */
    private static final String REQ_RECHERCHE =
            "SELECT v.codesPostaux FROM Ville v WHERE v.id = :pId";

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_CP_ID = "Select c FROM CodePostal c WHERE c.id = :pId";
    
    /**
     * Default constructor.
     */
    public DaoCodePostal() {
    }

    @Override
    public List<CodePostal> rechercher(Ville paramVille) throws AnarmorixException {

        try {
            List<CodePostal> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pId", paramVille .getCodeInsee()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("La ville n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "La ville n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public CodePostal ajouter(CodePostal paramCodePostal) throws AnarmorixException {
        try {
            em.persist(paramCodePostal);
            return paramCodePostal;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            CodePostal cp = (CodePostal) em.createQuery(REQ_CP_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(cp);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public CodePostal MettreAJour(Integer paramId) throws AnarmorixException {
        try {
            CodePostal cp = (CodePostal) em.createQuery(REQ_CP_ID).setParameter("pId", paramId).getSingleResult();
            CodePostal updated = em.merge(cp);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
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