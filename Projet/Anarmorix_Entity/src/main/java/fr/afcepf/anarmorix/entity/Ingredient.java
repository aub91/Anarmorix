package fr.afcepf.anarmorix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant les ingredients.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Id de l'ingrédient.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Quantité de l'ingredient.
     */
    @Column(name = "quantite", nullable = false)
    private Integer quantite;
    /**
     * Unité de quantité de l'ingrédient.
     */
    @ManyToOne
    @JoinColumn(name = "id_unite", nullable = true, foreignKey = @ForeignKey(name = "FK_Ingredient_Unite"))
    private UnitePackaging unite;

    /**
     * Recette comprenant l'ingrédient.
     */
    @ManyToOne
    @JoinColumn(name = "id_recette", nullable = false, foreignKey = @ForeignKey(name = "FK_Ingredient_Recette"))
    private Recette recette;

    /**
     * Produit type correspondant à l'ingrédient.
     */
    @ManyToOne
    @JoinColumn(name = "id_type_produit", nullable = false, foreignKey = @ForeignKey(name = "FK_Ingredient_typeProduit"))
    private TypeProduit typeProduit;

    /**
     * Default constructor.
     */
    public Ingredient() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramQuantite the quantite to set
     * @param paramRecette the recette to set
     * @param paramTypeProduit the typeProduit to set
     * @param paramUnite the unite to set
     */
    public Ingredient(Integer paramId, Integer paramQuantite, UnitePackaging paramUnite, Recette paramRecette, TypeProduit paramTypeProduit) {
        super();
        id = paramId;
        quantite = paramQuantite;
        unite = paramUnite;
        recette = paramRecette;
        typeProduit = paramTypeProduit;
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
     * @return the quantite
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     * @param paramQuantite the quantite to set
     */
    public void setQuantite(Integer paramQuantite) {
        quantite = paramQuantite;
    }

    /**
     * @return the recette
     */
    public Recette getRecette() {
        return recette;
    }

    /**
     * @param paramRecette the recette to set
     */
    public void setRecette(Recette paramRecette) {
        recette = paramRecette;
    }

    /**
     * @return the typeProduit
     */
    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    /**
     * @param paramTypeProduit the typeProduit to set
     */
    public void setTypeProduit(TypeProduit paramTypeProduit) {
        typeProduit = paramTypeProduit;
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

}