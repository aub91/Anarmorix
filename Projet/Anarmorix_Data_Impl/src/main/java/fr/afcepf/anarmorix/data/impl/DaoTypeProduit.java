package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoTypeProduit;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 *  Classe implémentant les méthodes de l'{@link IDaoTypeProduit}.
 */
@Remote(IDaoTypeProduit.class)
@Stateless
public class DaoTypeProduit implements IDaoTypeProduit {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_TYPE_ID = "Select t FROM TypeProduit t WHERE t.id = :pId";

    /**
     * Default constructor.
     */
    public DaoTypeProduit() {
    }

    @Override
    public List<TypeProduit> rechercher(Categorie paramCategorie) throws AnarmorixException {
        try {
            List<TypeProduit> types = paramCategorie.getTypesProduits();
            List<Categorie> descendantes = paramCategorie.getCategoriesFilles();
            for (Categorie categorie : descendantes) {
                descendantes.addAll(categorie.getCategoriesFilles());
                types.addAll(categorie.getTypesProduits());
            }
            return types;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public TypeProduit ajouter(TypeProduit paramTypePdt) throws AnarmorixException {
        try {
            em.persist(paramTypePdt);
            return paramTypePdt;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        try {
            TypeProduit typeProduit = (TypeProduit) em.createQuery(REQ_TYPE_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(typeProduit);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public TypeProduit mettreAJour(Integer paramId) throws AnarmorixException {
        try {
            TypeProduit typeProduit = (TypeProduit) em.createQuery(REQ_TYPE_ID).setParameter("pId", paramId).getSingleResult();
            TypeProduit updated = em.merge(typeProduit);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}