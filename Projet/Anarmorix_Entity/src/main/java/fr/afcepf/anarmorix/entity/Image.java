package fr.afcepf.anarmorix.entity;


import java.util.*;

/**
 * 
 */
public class Image {

    /**
     * Default constructor
     */
    public Image() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String cheminImage;


    /**
     * 
     */
    private Set<Produit> produits;

    /**
     * 
     */
    private Commerce commerce;

    /**
     * 
     */
    private Exploitation exploitation;

    /**
     * 
     */
    private Set<TypeProduit> typesProduits;
    /**
     * 
     */
    private Adherent adherent;

}