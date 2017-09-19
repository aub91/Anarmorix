package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant un catalogue.
 */
@Entity
@Table(name = "catalogue")
public class Catalogue implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Id du catalogue.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Date de début de mise en activité du catalogue.
     */
    @Column(name = "dateDebut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    /**
     * Date de fin de validité du catalogue.
     */
    @Column(name = "dateFin", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    /**
     * Date de création du catalogue.
     */
    @Column(name = "dateCreation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    /**
     * {@link Exploitation} possédant le catalogue.
     */
    @ManyToOne
    @JoinColumn(name = "id_exploitation", nullable = false, foreignKey = @ForeignKey(name = "FK_Catalogue_Exploitation"))
    private Exploitation exploitation;
    /**
     * Liste de produits du catalogue.
     */
    @ManyToMany
    @JoinTable(name = "catalogue_produit", joinColumns = @JoinColumn(name = "catalogue_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"))
    private List<Produit> produits;
    /**
     * Default constructor.
     */
    public Catalogue() {
    }
    /**
     * COnstructeur surchargé.
     * @param paramId the id to set
     * @param paramDateDebut the dateDebut to set
     * @param paramDateFin the dateFin to set
     * @param paramDateCreation the dateCreation to set
     * @param paramExploitation the exploitation to set
     */
    public Catalogue(Integer paramId, Date paramDateDebut, Date paramDateFin, Date paramDateCreation,
            Exploitation paramExploitation) {
        super();
        id = paramId;
        dateDebut = paramDateDebut;
        dateFin = paramDateFin;
        dateCreation = paramDateCreation;
        exploitation = paramExploitation;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }
    /**
     * @param paramDateDebut the dateDebut to set
     */
    public void setDateDebut(Date paramDateDebut) {
        dateDebut = paramDateDebut;
    }
    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }
    /**
     * @param paramDateFin the dateFin to set
     */
    public void setDateFin(Date paramDateFin) {
        dateFin = paramDateFin;
    }
    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }
    /**
     * @param paramDateCreation the dateCreation to set
     */
    public void setDateCreation(Date paramDateCreation) {
        dateCreation = paramDateCreation;
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