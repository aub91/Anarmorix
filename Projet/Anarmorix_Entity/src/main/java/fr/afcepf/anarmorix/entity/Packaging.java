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
 * Entité décrivant le packaging.
 */
@Entity
@Table(name = "packaging")
public class Packaging implements Serializable {

    /**
     * Numéro pour la sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Petite longueur d'une chaîne de caractères.
     */
    @Transient
    private static final int LONGUEUR_PETITE = 20;


    /**
     * Id du packaging.
     */
    @Id
    @Column(name = "packaging")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Valeur unitaire du produit.
     */
    @Column(name = "valeur_unitaire", nullable = false)
    private Double valeurUnitaire;

    /**
     * Libellé du packaging.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_PETITE)
    private String libelle;

    /**
     * Unité du packaging.
     */
    @ManyToOne
    @JoinColumn(name = "unite", nullable = true, foreignKey = @ForeignKey(name = "FK_Packaging_Unite"))
    private UnitePackaging unite;

    /**
     * Liste des produits vendus sous ce packaging.
     */
    @OneToMany(mappedBy = "packaging")
    private List<Produit> produits;

    /**
     * Packaging pere du packaging.
     */
    @ManyToOne
    @JoinColumn(name = "packaging_pere", nullable = true, foreignKey = @ForeignKey(name = "FK_Packaging_PackagingPere"))
    private Packaging packagingPere;

    /**
     * Liste des packaging fils.
     */
    @OneToMany(mappedBy = "packagingPere")
    private List<Packaging> packagingFils;

    /**
     * Default constructor.
     */
    public Packaging() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramValeurUnitaire the valeurUnitaire to set
     * @param paramLibelle the libelle to set
     * @param paramUnite the unite to set
     * @param paramPackagingPere the packagingPere to set
     */
    public Packaging(Integer paramId, Double paramValeurUnitaire, String paramLibelle, UnitePackaging paramUnite,
            Packaging paramPackagingPere) {
        super();
        id = paramId;
        valeurUnitaire = paramValeurUnitaire;
        libelle = paramLibelle;
        unite = paramUnite;
        packagingPere = paramPackagingPere;
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
     * @return the valeurUnitaire
     */
    public Double getValeurUnitaire() {
        return valeurUnitaire;
    }

    /**
     * @param paramValeurUnitaire the valeurUnitaire to set
     */
    public void setValeurUnitaire(Double paramValeurUnitaire) {
        valeurUnitaire = paramValeurUnitaire;
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
     * @return the unite
     */
    public UnitePackaging getUnite() {
        return unite;
    }

    /**
     * @param paramUnite the unite to set
     */
    public void setUnite(UnitePackaging paramUnite) {
        unite = paramUnite;
    }

    /**
     * @return the produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * @param paramProduits the produits to set
     */
    public void setProduits(List<Produit> paramProduits) {
        produits = paramProduits;
    }

    /**
     * @return the packagingPere
     */
    public Packaging getPackagingPere() {
        return packagingPere;
    }

    /**
     * @param paramPackagingPere the packagingPere to set
     */
    public void setPackagingPere(Packaging paramPackagingPere) {
        packagingPere = paramPackagingPere;
    }

    /**
     * @return the packagingFils
     */
    public List<Packaging> getPackagingFils() {
        return packagingFils;
    }

    /**
     * @param paramPackagingFils the packagingFils to set
     */
    public void setPackagingFils(List<Packaging> paramPackagingFils) {
        packagingFils = paramPackagingFils;
    }
}