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
 * Entité représentant une catégorie de produit.
 */
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

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
     * Id de la catégorie.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Libelle de la catégorie.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_MOYENNE)
    private String libelle;

    /**
     * Liste des Types produits rattachés à la catégorie.
     */
    @OneToMany(mappedBy = "categorie")
    private List<TypeProduit> typesProduits;

    /**
     * Liste des catégories filles.
     */
    @OneToMany(mappedBy = "categorieMere")
    private List<Categorie> categoriesFilles;

    /**
     * Catégorie mère de la catégorie.
     */
    @ManyToOne
    @JoinColumn(name = "id_categorie_mere", nullable = true, foreignKey = @ForeignKey(name = "FK_Categorie_Categorie"))
    private Categorie categorieMere;

    /**
     * Default constructor.
     */
    public Categorie() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     * @param paramCategorieMere the categorieMere to set
     */
    public Categorie(Integer paramId, String paramLibelle, Categorie paramCategorieMere) {
        super();
        id = paramId;
        libelle = paramLibelle;
        categorieMere = paramCategorieMere;
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
     * @return the categoriesFilles
     */
    public List<Categorie> getCategoriesFilles() {
        return categoriesFilles;
    }
    /**
     * @param paramCategoriesFilles the categoriesFilles to set
     */
    public void setCategoriesFilles(List<Categorie> paramCategoriesFilles) {
        categoriesFilles = paramCategoriesFilles;
    }
    /**
     * @return the categorieMere
     */
    public Categorie getCategorieMere() {
        return categorieMere;
    }
    /**
     * @param paramCategorieMere the categorieMere to set
     */
    public void setCategorieMere(Categorie paramCategorieMere) {
        categorieMere = paramCategorieMere;
    }

    /**
     * @return the typesProduits
     */
    public List<TypeProduit> getTypesProduits() {
        return typesProduits;
    }
    /**
     * @param paramTypesProduits the typesProduits to set
     */
    public void setTypesProduits(List<TypeProduit> paramTypesProduits) {
        typesProduits = paramTypesProduits;
    }
}