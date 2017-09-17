package fr.afcepf.anarmorix.entity;

import java.util.List;

import javax.persistence.ManyToMany;

/**
 * 
 */
public class SocieteDeLivraison extends Adherent {

    /**
     * Default constructor
     */
    public SocieteDeLivraison() {
    }

    /**
     * 
     */
    private List<Livreur> livreurs;

    /**
     * 
     */
    @ManyToMany(mappedBy = "societesDeLivraison")
    private List<Ville> villesLivrees;

}