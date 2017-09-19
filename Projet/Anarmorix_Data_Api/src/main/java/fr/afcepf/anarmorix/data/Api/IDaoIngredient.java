package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.Ingredient;

/**
 * 
 */
public interface IDaoIngredient {

    /**
     * @param ingredient 
     * @return
     */
    public Ingredient ajouter(Ingredient ingredient);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Ingredient id);

    /**
     * @param id 
     * @return
     */
    public Ingredient mettreAJour(Ingredient id);

}