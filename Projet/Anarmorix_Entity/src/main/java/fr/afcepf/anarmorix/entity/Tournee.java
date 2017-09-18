package afcepf.anarmorix.entity;

import java.util.*;

/**
 * 
 */
public class Tournee {

    /**
     * Default constructor
     */
    public Tournee() {
    }

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Date dateHeureDebut;

    /**
     * 
     */
    private Date dateHeureFin;

    /**
     * 
     */
    private Set<LigneCommande> lignesCmd;

    /**
     * 
     */
    private Livreur livreur;

}