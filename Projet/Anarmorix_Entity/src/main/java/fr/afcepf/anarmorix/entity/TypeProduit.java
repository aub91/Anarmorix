package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * Entité représentant un type de produit.
 */
@Entity
@Table(name = "typeProduit")
public class TypeProduit implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Longueur moyenne d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_MOYENNE = 50;
    /**
     * Id du type de produit.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Libelle du type produit.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_MOYENNE)
    private String libelle;

    /**
     * Valeur de durée de conservation.
     */
    @Column(name = "dureConservation", nullable = true)
    private Integer dureeDeConservation;


    /**
     * Taux de TVA applicable au tupe de produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_tva", nullable = true, foreignKey = @ForeignKey(name = "FK_TypeProduit_Tva"))
    private TauxTVA tva;

    /**
     * Catégorie du type produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_categorie", nullable = false, foreignKey = @ForeignKey(name = "FK_TypeProduit_Categorie"))
    private Categorie categorie;

    /**
     * Unité de la durée de conservation.
     */
    @Enumerated(EnumType.STRING)
    private UniteDureeConservation uniteConservation;

    /**
     * Liste des ingrédients de recette ayant ce type.
     */
    @OneToMany(mappedBy = "typeProduit")
    private List<Ingredient> ingredients;

    /**
     * Image par défaut du type produit.
     */
    @ManyToOne
    @JoinColumn(name = "id_imageDefaut", nullable = false, foreignKey = @ForeignKey(name = "FK_TypeProduit_Image"))
    private Image imageParDefaut;
    /**
     * Default constructor.
     */
    public TypeProduit() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     * @param paramDureeDeConservation the dureeConservation to set
     * @param paramTva the tva to set
     * @param paramCategorie the categorie to set
     * @param paramUniteConservation the uniteConservation to set
     * @param paramImageParDefaut the imageParDefaut to set
     */
    public TypeProduit(Integer paramId, String paramLibelle, Integer paramDureeDeConservation, TauxTVA paramTva, Categorie paramCategorie,
            UniteDureeConservation paramUniteConservation, Image paramImageParDefaut) {
        super();
        id = paramId;
        libelle = paramLibelle;
        dureeDeConservation = paramDureeDeConservation;
        tva = paramTva;
        categorie = paramCategorie;
        uniteConservation = paramUniteConservation;
        imageParDefaut = paramImageParDefaut;
    }
    /**
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }
    /**
     * @param paramCategorie the categorie to set
     */
    public void setCategorie(Categorie paramCategorie) {
        categorie = paramCategorie;
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
     * @return the dureeDeConservation
     */
    public Integer getDureeDeConservation() {
        return dureeDeConservation;
    }
    /**
     * @param paramDureeDeConservation the dureeDeConservation to set
     */
    public void setDureeDeConservation(Integer paramDureeDeConservation) {
        dureeDeConservation = paramDureeDeConservation;
    }
    /**
     * @return the tva
     */
    public TauxTVA getTva() {
        return tva;
    }
    /**
     * @param paramTva the tva to set
     */
    public void setTva(TauxTVA paramTva) {
        tva = paramTva;
    }
    /**
     * @return the uniteConservation
     */
    public UniteDureeConservation getUniteConservation() {
        return uniteConservation;
    }
    /**
     * @param paramUniteConservation the uniteConservation to set
     */
    public void setUniteConservation(UniteDureeConservation paramUniteConservation) {
        uniteConservation = paramUniteConservation;
    }
    /**
     * @return the ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    /**
     * @param paramIngredients the ingredients to set
     */
    public void setIngredients(List<Ingredient> paramIngredients) {
        ingredients = paramIngredients;
    }
    /**
     * @return the imageParDefaut
     */
    public Image getImageParDefaut() {
        return imageParDefaut;
    }
    /**
     * @param paramImageParDefaut the imageParDefaut to set
     */
    public void setImageParDefaut(Image paramImageParDefaut) {
        imageParDefaut = paramImageParDefaut;
    }
    
}