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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant une tournée.
 */
@Entity
@Table(name = "tournee")
public class Tournee implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Id de l'adhérent.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Date et heure de début de la livraison.
     */
    @Column(name = "dateHeureDebut", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureDebut;

    /**
     * Date et heure de fin de la livraison.
     */
    @Column(name = "dateHeureFin", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureFin;

    /**
     * Liste des lignes de commande associés à la livraison.
     */
    @OneToMany(mappedBy = "tournee")
    private List<LigneCommande> lignesCmd;

    /**
     * Société de livraison responsable de la livraison.
     */
    @ManyToOne
    @JoinColumn(name = "id_societe", nullable = true, foreignKey = @ForeignKey(name = "FK_Tournee_SocieteLivraison"))
    private SocieteDeLivraison societe;

    /**
     * Livreur effectuant la livraison.
     */
    @ManyToOne
    @JoinColumn(name = "id_livreur", nullable = true, foreignKey = @ForeignKey(name = "FK_Tournee_Livreur"))
    private Livreur livreur;

    /**
     * Default constructor.
     */
    public Tournee() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDateHeureDebut the dateHeureDebut to set
     * @param paramDateHeureFin the dateHeureFin to set
     * @param paramSociete the societeLivraison to set
     */
    public Tournee(Integer paramId, Date paramDateHeureDebut, Date paramDateHeureFin, SocieteDeLivraison paramSociete) {
        super();
        id = paramId;
        dateHeureDebut = paramDateHeureDebut;
        dateHeureFin = paramDateHeureFin;
        societe = paramSociete;
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
     * @return the dateHeureDebut
     */
    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }
    /**
     * @param paramDateHeureDebut the dateHeureDebut to set
     */
    public void setDateHeureDebut(Date paramDateHeureDebut) {
        dateHeureDebut = paramDateHeureDebut;
    }
    /**
     * @return the dateHeureFin
     */
    public Date getDateHeureFin() {
        return dateHeureFin;
    }
    /**
     * @param paramDateHeureFin the dateHeureFin to set
     */
    public void setDateHeureFin(Date paramDateHeureFin) {
        dateHeureFin = paramDateHeureFin;
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
     * @return the livreur
     */
    public Livreur getLivreur() {
        return livreur;
    }
    /**
     * @param paramLivreur the livreur to set
     */
    public void setLivreur(Livreur paramLivreur) {
        livreur = paramLivreur;
    }
    /**
     * @return the societeDeLivraison
     */
    public SocieteDeLivraison getSociete() {
        return societe;
    }
    /**
     * @param paramSociete the societeDeLivraison to set
     */
    public void setSociete(SocieteDeLivraison paramSociete) {
        societe = paramSociete;
    }
}