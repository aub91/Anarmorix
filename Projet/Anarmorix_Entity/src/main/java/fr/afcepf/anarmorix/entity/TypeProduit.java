package afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Entité représentant un type de produit.
 */
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
    private Integer dureeDeConservation;


    /**
     * 
     */
    private TauxTVA tva;

    /**
     * 
     */
    private UniteDureeConservation uniteConservation;

    /**
     * 
     */
    private List<Ingredient> ingredients;

    /**
     * 
     */
    private Image imageParDefaut;
    /**
     * Default constructor.
     */
    public TypeProduit() {
    }
}