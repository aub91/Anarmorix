package afcepf.anarmorix.entity;

import java.util.*;

/**
 * 
 */
public class TypeProduit {

    /**
     * Default constructor
     */
    public TypeProduit() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    private Integer dureeDeConservation;


    /**
     * 
     */
    private TauxTVA tva;

    /**
     * 
     */
    private UniteDureeConservation unite;

    /**
     * 
     */
    private Set<Ingredient> ingredients;

    /**
     * 
     */
    private Image imageParDefaut;

}