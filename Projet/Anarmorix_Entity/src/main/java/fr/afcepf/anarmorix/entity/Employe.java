package fr.afcepf.anarmorix.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Entité représentant un employé.
 */
@Entity
@DiscriminatorValue("Employe")
public class Employe extends Professionnel {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Le point relais où travaille l'employé.
     */
    @ManyToOne
    @JoinColumn(name = "id_relais", nullable = false, foreignKey = @ForeignKey(name = "FK_Employe_Relais"))
    private PointRelais relais;
    /**
     * Default constructor.
     */
    public Employe() {
    }
    /**
     * Constructeur surchargé.
     * @param paramRelais the relais to set
     */
    public Employe(PointRelais paramRelais) {
        super();
        relais = paramRelais;
    }
    /**
     * @return the relais
     */
    public PointRelais getRelais() {
        return relais;
    }
    /**
     * @param paramRelais the relais to set
     */
    public void setRelais(PointRelais paramRelais) {
        relais = paramRelais;
    }
}