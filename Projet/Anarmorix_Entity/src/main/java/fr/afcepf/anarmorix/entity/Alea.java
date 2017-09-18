package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant un aléa.
 */
@Entity
@Table(name = "alea")
public class Alea implements Serializable {
    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Très grande longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_TRES_GRANDE = 300;
    /**
     * Id de l'aléa.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Description d'un aléa si catégorie autre.
     */
    @Column(name = "description_Autre_Alea", nullable = false, length = LONGUEUR_TRES_GRANDE)
    private String descriptionAutreAlea;
    /**
     * Date de création de l'aléa.
     */
    @Column(name = "dateAlea", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAlea;

    /**
     * Liste des lignes de commandes ayant rencontrés cet aléa.
     */
    @ManyToMany
    @JoinTable(name = "alea_ligneCmd", joinColumns = @JoinColumn(name = "alea_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "ligneCmd_id", referencedColumnName = "id"))
    private List<LigneCommande> lignesCmd;

    /**
     * Libellé de l'aléa.
     */
    @Enumerated(EnumType.STRING)
    private LibelleAlea libelle;
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
     * @return the descriptionAutreAlea
     */
    public String getDescriptionAutreAlea() {
        return descriptionAutreAlea;
    }

    /**
     * @param paramDescriptionAutreAlea the descriptionAutreAlea to set
     */
    public void setDescriptionAutreAlea(String paramDescriptionAutreAlea) {
        descriptionAutreAlea = paramDescriptionAutreAlea;
    }

    /**
     * @return the dateAlea
     */
    public Date getDateAlea() {
        return dateAlea;
    }

    /**
     * @param paramDateAlea the dateAlea to set
     */
    public void setDateAlea(Date paramDateAlea) {
        dateAlea = paramDateAlea;
    }

    /**
     * @return the lignesCmd
     */
    public List<LigneCommande> getLignesCmd() {
        return lignesCmd;
    }

    /**
     * @param paramLignesCmd the lignesCmd to set
     */
    public void setLignesCmd(List<LigneCommande> paramLignesCmd) {
        lignesCmd = paramLignesCmd;
    }

    /**
     * @return the libelle
     */
    public LibelleAlea getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(LibelleAlea paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     * Default constructor.
     */
    public Alea() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDescriptionAutreAlea the descriptionAutreAlea to set
     * @param paramDateAlea the dateAlea to set
     * @param paramLibelle the libelle to set
     */
    public Alea(Integer paramId, String paramDescriptionAutreAlea, Date paramDateAlea, LibelleAlea paramLibelle) {
        super();
        id = paramId;
        descriptionAutreAlea = paramDescriptionAutreAlea;
        dateAlea = paramDateAlea;
        libelle = paramLibelle;
    }

}