package fr.afcepf.anarmorix.entity;

import java.io.Serializable;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Entité représentant le producteur.
 */
public class Producteur extends Professionnel implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Exploitation où travaille e producteur.
     */
    @ManyToOne
    @JoinColumn(name = "id_exploitation", nullable = false, foreignKey = @ForeignKey(name = "FK_Producteur_Adherent"))
    private Exploitation exploitation;

    /**
     * Default constructor.
     */
    public Producteur() {
    }

    /**
     * Constructeur surchargé.
     * @param paramExploitation the exploitation to set
     */
    public Producteur(Exploitation paramExploitation) {
        super();
        exploitation = paramExploitation;
    }

    /**
     * @return the exploitation
     */
    public Exploitation getExploitation() {
        return exploitation;
    }

    /**
     * @param paramExploitation the exploitation to set
     */
    public void setExploitation(Exploitation paramExploitation) {
        exploitation = paramExploitation;
    }
}