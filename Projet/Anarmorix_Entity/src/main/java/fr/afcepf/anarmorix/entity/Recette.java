package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant une recette.
 */
@Entity
@Table(name = "recette")
public class Recette implements Serializable {

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
     * Id de l'adhérent.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Libellé de la recette.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_MOYENNE)
    private String libelle;

    /**
     * Liste des ingrédients de la recette.
     */
    @OneToMany(mappedBy = "recette")
    private List<Ingredient> ingredients;
    /**
     * Default constructor.
     */
    public Recette() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     */
    public Recette(Integer paramId, String paramLibelle) {
        super();
        id = paramId;
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

}