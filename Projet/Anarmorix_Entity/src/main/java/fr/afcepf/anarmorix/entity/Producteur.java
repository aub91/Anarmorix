package fr.afcepf.anarmorix.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Entité représentant le producteur.
 */
@Entity
@DiscriminatorValue("Producteur")
public class Producteur extends Professionnel {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Exploitation où travaille e producteur.
     */
    @ManyToOne
    @JoinColumn(name = "id_exploitation", nullable = true, foreignKey = @ForeignKey(name = "FK_Producteur_Exploitation"))
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