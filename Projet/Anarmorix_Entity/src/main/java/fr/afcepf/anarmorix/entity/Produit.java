package fr.afcepf.anarmorix.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Transient;

/**
 * Entité représentant un produit "concret".
 */

public class Produit extends TypeProduit {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

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
    /**
     * Default constructor.
     */
    public Produit() {
    }

}