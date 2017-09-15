package afcepf.anarmorix.entity;

import java.util.*;

/**
 * 
 */
public class Packaging {

    /**
     * Default constructor
     */
    public Packaging() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Double valeurUnitaire;

    /**
     * 
     */
    private String libelle;

    /**
     * 
     */
    private UnitePackaging unite;

    /**
     * 
     */
    private Set<Produit> produits;

    /**
     * 
     */
    private Packaging packagingPere;

    /**
     * 
     */
    private Set<Packaging> packagingFils;

}