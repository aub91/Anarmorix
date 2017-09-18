package afcepf.anarmorix.entity;

import java.util.*;

/**
 * 
 */
public class JourOuverture {

    /**
     * Default constructor
     */
    public JourOuverture() {
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
    private PointRelais relais;

    /**
     * 
     */
    private Set<Horaire> horairesOuverture;

}