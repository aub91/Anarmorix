package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant les indisponibilités.
 */
@Entity
@Table(name = "indisponibilite")
public class Indisponibilite implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Très grande longueur de chaîne de caractères.
     */
    @Transient
    private static final int LONGUEUR_TRES_GRANDE = 300;

    /**
     * Id de l'indisponibilité.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Description d'une indisponibilité non répertoriée.
     */
    @Column(name = "descriptionAutreIndispo", nullable = true, length = LONGUEUR_TRES_GRANDE)
    private String descriptionAutreIndispo;

    /**
     * Date de début de l'indisponibilité.
     */
    @Column(name = "dateDebut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    /**
     * Date de fin de l'indisponibilité.
     */
    @Column(name = "dateFin", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    /**
     * Date de saisie de l'indisponibilité.
     */
    @Column(name = "dateSaisie", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSaisie;

    /**
     * Commerce concerné par l'indisponibilité.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commerce", nullable = true, foreignKey = @ForeignKey(name = "FK_Indisponibilite_Commerce"))
    private Commerce commerce;

    /**
     * Libellé de l'indisponibilité.
     */
    @Enumerated(EnumType.STRING)
    private LibelleIndispo libelle;

    /**
     * Default constructor.
     */
    public Indisponibilite() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDescriptionAutreIndispo the descriptionAutreIndispo to set
     * @param paramDateDebut the dateDebut to set
     * @param paramDateFin the dateFin to set
     * @param paramDateSaisie the dateSaisie to set
     * @param paramCommerce the commerce to set
     * @param paramLibelle the libelle to set
     */
    public Indisponibilite(Integer paramId, String paramDescriptionAutreIndispo, Date paramDateDebut, Date paramDateFin,
            Date paramDateSaisie, Commerce paramCommerce, LibelleIndispo paramLibelle) {
        super();
        id = paramId;
        descriptionAutreIndispo = paramDescriptionAutreIndispo;
        dateDebut = paramDateDebut;
        dateFin = paramDateFin;
        dateSaisie = paramDateSaisie;
        commerce = paramCommerce;
        libelle = paramLibelle;
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
     * @return the descriptionAutreIndispo
     */
    public String getDescriptionAutreIndispo() {
        return descriptionAutreIndispo;
    }

    /**
     * @param paramDescriptionAutreIndispo the descriptionAutreIndispo to set
     */
    public void setDescriptionAutreIndispo(String paramDescriptionAutreIndispo) {
        descriptionAutreIndispo = paramDescriptionAutreIndispo;
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
     * @return the dateSaisie
     */
    public Date getDateSaisie() {
        return dateSaisie;
    }

    /**
     * @param paramDateSaisie the dateSaisie to set
     */
    public void setDateSaisie(Date paramDateSaisie) {
        dateSaisie = paramDateSaisie;
    }

    /**
     * @return the commerce
     */
    public Commerce getCommerce() {
        return commerce;
    }

    /**
     * @param paramCommerce the commerce to set
     */
    public void setCommerce(Commerce paramCommerce) {
        commerce = paramCommerce;
    }

    /**
     * @return the libelle
     */
    public LibelleIndispo getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(LibelleIndispo paramLibelle) {
        libelle = paramLibelle;
    }
}