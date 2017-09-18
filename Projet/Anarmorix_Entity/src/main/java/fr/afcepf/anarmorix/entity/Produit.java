package afcepf.anarmorix.entity;

import java.util.*;

/**
 * 
 */
public class Produit extends TypeProduit {

    /**
     * Default constructor
     */
    public Produit() {
    }

    /**
     * 
     */
    private Date dateDeProduction;

    /**
     * 
     */
    private Double prixUnitaire;

    /**
     * 
     */
    private Integer quantiteEnStock;

    /**
     * 
     */
    private Set<LigneCommande> lignesCmd;


    /**
     * 
     */
    private Image image;

    /**
     * 
     */
    private Packaging packaging;

}