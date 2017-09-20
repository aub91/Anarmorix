package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant le motif de désinscription.
 */
@Entity
@Table(name = "motifDesinscription")
public class MotifDesinscription implements Serializable {

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
     * Id du motif de désinscription.
     */
    @Id
    @JoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Description d'un motif non répertorié.
     */
    @Column(name = "description_Autre_Motif", nullable = true, length = LONGUEUR_TRES_GRANDE)
    private String descriptionAutreMotif;

    /**
     * Liste des adhérents associés à un motif de désinscription.
     */
    @OneToMany(mappedBy = "motifDesinscription")
    private List<Adherent> adherents;

    /**
     * Libellé du motif de désinscription.
     */
    @Enumerated(EnumType.STRING)
    private LibelleMotifDesinscription libelle;

    /**
     * Default constructor.
     */
    public MotifDesinscription() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDescriptionAutreMotif the descriptionAutreMotif to set
     * @param paramLibelle the Libelle to set
     */
    public MotifDesinscription(Integer paramId, String paramDescriptionAutreMotif,
            LibelleMotifDesinscription paramLibelle) {
        super();
        id = paramId;
        descriptionAutreMotif = paramDescriptionAutreMotif;
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
     * @return the descriptionAutreMotif
     */
    public String getDescriptionAutreMotif() {
        return descriptionAutreMotif;
    }

    /**
     * @param paramDescriptionAutreMotif the descriptionAutreMotif to set
     */
    public void setDescriptionAutreMotif(String paramDescriptionAutreMotif) {
        descriptionAutreMotif = paramDescriptionAutreMotif;
    }

    /**
     * @return the adherents
     */
    public List<Adherent> getAdherents() {
        return adherents;
    }

    /**
     * @param paramAdherents the adherents to set
     */
    public void setAdherents(List<Adherent> paramAdherents) {
        adherents = paramAdherents;
    }

    /**
     * @return the libelle
     */
    public LibelleMotifDesinscription getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle the libelle to set
     */
    public void setLibelle(LibelleMotifDesinscription paramLibelle) {
        libelle = paramLibelle;
    }
}