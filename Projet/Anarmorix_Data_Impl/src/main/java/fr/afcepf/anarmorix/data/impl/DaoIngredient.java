package fr.afcepf.anarmorix.data.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoIngredient;
import fr.afcepf.anarmorix.entity.Ingredient;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe implémentant les méthodes de l'{@link IDaoIngredient}.
 */
@Remote(IDaoIngredient.class)
@Stateless
public class DaoIngredient implements IDaoIngredient {
    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;

    /**
     * Requête permettant de récupérer un catalogue en fonction de son Id.
     */
    private static final String REQ_INGREDIENT_ID = "Select i FROM Igredient i WHERE i.id = :pId";

    /**
     * Default constructor.
     */
    public DaoIngredient() {
    }

    @Override
    public Ingredient ajouter(Ingredient paramIngredient) throws AnarmorixException {
        try {
            em.persist(paramIngredient);
            return paramIngredient;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Ingredient paramId) throws AnarmorixException {
        try {
            Ingredient ingredient = (Ingredient) em.createQuery(REQ_INGREDIENT_ID).setParameter("pId", paramId).getSingleResult();
            em.remove(ingredient);
            return true;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Ingredient mettreAJour(Ingredient paramId) throws AnarmorixException {
        try {
            Ingredient ingredient = (Ingredient) em.createQuery(REQ_INGREDIENT_ID).setParameter("pId", paramId).getSingleResult();
            Ingredient updated = em.merge(ingredient);
            return updated;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

}