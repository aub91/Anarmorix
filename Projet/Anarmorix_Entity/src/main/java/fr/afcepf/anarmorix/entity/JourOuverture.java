package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant le jour d'ouverture.
 */
@Entity
@Table(name = "jourOuverture")
public class JourOuverture implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Petite longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_PETITE = 20;

    /**
     * Id du jour d'ouverture.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Libelle du jour d'ouverture.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_PETITE)
    private String libelle;

    /**
     * Point-relais associé au jour d'ouverture.
     */
    @ManyToOne
    @JoinColumn(name = "id_pointRelais", nullable = false, foreignKey = @ForeignKey(name = "FK_JourOuverture_Point_Relais"))
    private PointRelais relais;

    /**
     * Liste des horaires d'ouvertures associés au jour d'ouverture.
     */
    @OneToMany(mappedBy = "jour")
    private List<Horaire> horairesOuverture;

    /**
     * Default constructor.
     */
    public JourOuverture() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     * @param paramRelais the Relais to set
     */
    public JourOuverture(Integer paramId, String paramLibelle, PointRelais paramRelais) {
        super();
        id = paramId;
        libelle = paramLibelle;
        relais = paramRelais;
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
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
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