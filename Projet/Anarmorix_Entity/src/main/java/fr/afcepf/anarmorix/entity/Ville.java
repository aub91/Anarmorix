package fr.afcepf.anarmorix.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.ManyToMany;

/**
 * 
 */
public class Ville {

    /**
     * Default constructor
     */
    public Ville() {
    }

    /**
     * 
     */
    private String codeInsee;

    /**
     * 
     */
    private String nomVillle;

    /**
     * 
     */
    private Set<Adresse> adresses;

    /**
     * 
     */
    private Set<SocieteDeLivraison> socitetesDeLivraison;

    /**
     * 
     */
    @ManyToMany(mappedBy = "villes")
    private List<CodePostal> codesPostaux;

}