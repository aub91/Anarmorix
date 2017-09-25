package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.Ingredient;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoIngredient {

    /**
     * @param ingredient 
     * @return
     */
    public Ingredient ajouter(Ingredient ingredient) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Ingredient id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Ingredient mettreAJour(Ingredient id) throws AnarmorixException;

}