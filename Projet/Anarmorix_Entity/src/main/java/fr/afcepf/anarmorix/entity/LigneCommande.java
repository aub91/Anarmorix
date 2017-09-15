package afcepf.anarmorix.entity;

import java.util.*;

import javax.persistence.ManyToMany;

/**
 * 
 */
public class LigneCommande {

    /**
     * Default constructor
     */
    public LigneCommande() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Double quantiteCommandee;

    /**
     * 
     */
    private Double quantitePreparee;

    /**
     * 
     */
    private Double quantiteLivree;

    /**
     * 
     */
    private Double quantiteDelivree;

    /**
     * 
     */
    private Date dateDebutPreparation;

    /**
     * 
     */
    private Date dateFinPreparation;

    /**
     * 
     */
    private Date dateRetraitProducteur;

    /**
     * 
     */
    private Date dateLivraisonPtRel;

    /**
     * 
     */
    private Date dateRetraitPtRel;

    /**
     * 
     */
    private Produit produit;


    /**
     * 
     */
    @ManyToMany(mappedBy = "lignesCmd")
    private List<Alea> aleas;

    /**
     * 
     */
    private Tournee tournee;


}