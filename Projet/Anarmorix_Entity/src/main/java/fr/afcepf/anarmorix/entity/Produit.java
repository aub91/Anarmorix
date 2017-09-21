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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant un produit "concret".
 */
@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Id du produit.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Type du produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false, foreignKey = @ForeignKey(name = "FK_Produit_TypeProduit"))
    private TypeProduit type;
    /**
     * Date de production du produit.
     */
    @Column(name = "dateProduction", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeProduction;

    /**
     * Prix unitaire du produit.
     */
    @Column(name = "prixUnitaire", nullable = false, columnDefinition = "DECIMAL(12,2)")
    private Double prixUnitaire;

    /**
     * Quantité en stock.
     */
    @Column(name = "quantite", nullable = false, columnDefinition = "DECIMAL(12,2)")
    private Double quantiteEnStock;
    /**
     * Petite longueur d'une chaîne de caractères.
     */
    @Transient
    private static final int LONGUEUR_DESCRIPTIF = 200;
    /**
     * Description du produit.
     */
    @Column(name = "descriptif", nullable = true, length = LONGUEUR_DESCRIPTIF)
    private String descriptif;
    /**
     * Liste des lignes de commandes correspondant à ce produit.
     */
    @OneToMany(mappedBy = "produit")
    private List<LigneCommande> lignesCmd;
    /**
     * Liste des catalogues auxquels appartient le produit.
     */
    @ManyToMany(mappedBy = "produits")
    private List<Catalogue> catalogues;
    /**
     * Image spécifique au produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_image", nullable = true, foreignKey = @ForeignKey(name = "FK_Produit_Image"))
    private Image image;

    /**
     * Packaging du produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_packaging", nullable = true, foreignKey = @ForeignKey(name = "FK_Produit_Packaging"))
    private Packaging packaging;
    /**
     * Default constructor.
     */
    public Produit() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramType the type to set
     * @param paramDateDeProduction the dateProduction to set
     * @param paramPrixUnitaire the prixUnitaire to set
     * @param paramQuantiteEnStock the quantiteEnStock to set
     * @param paramImage the image to set
     * @param paramPackaging the packaging to set
     */
    public Produit(Integer paramId, TypeProduit paramType, Date paramDateDeProduction, Double paramPrixUnitaire,
            Double paramQuantiteEnStock, Image paramImage, Packaging paramPackaging) {
        super();
        id = paramId;
        type = paramType;
        dateDeProduction = paramDateDeProduction;
        prixUnitaire = paramPrixUnitaire;
        quantiteEnStock = paramQuantiteEnStock;
        image = paramImage;
        packaging = paramPackaging;
    }
    /**
     * @return the id.
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the paramId to set.
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the dateDeProduction
     */
    public Date getDateDeProduction() {
        return dateDeProduction;
    }
    /**
     * @param paramDateDeProduction the dateDeProduction to set
     */
    public void setDateDeProduction(Date paramDateDeProduction) {
        dateDeProduction = paramDateDeProduction;
    }
    /**
     * @return the prixUnitaire
     */
    public Double getPrixUnitaire() {
        return prixUnitaire;
    }
    /**
     * @param paramPrixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(Double paramPrixUnitaire) {
        prixUnitaire = paramPrixUnitaire;
    }
    /**
     * @return the quantiteEnStock
     */
    public Double getQuantiteEnStock() {
        return quantiteEnStock;
    }
    /**
     * @param paramQuantiteEnStock the quantiteEnStock to set
     */
    public void setQuantiteEnStock(Double paramQuantiteEnStock) {
        quantiteEnStock = paramQuantiteEnStock;
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
     * @return the image
     */
    public Image getImage() {
        return image;
    }
    /**
     * @param paramImage the image to set
     */
    public void setImage(Image paramImage) {
        image = paramImage;
    }
    /**
     * @return the packaging
     */
    public Packaging getPackaging() {
        return packaging;
    }
    /**
     * @param paramPackaging the packaging to set
     */
    public void setPackaging(Packaging paramPackaging) {
        packaging = paramPackaging;
    }
}