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
 * Entité représentant une unité de packaging.
 */
@Entity
@Table(name = "unitePackaging")
public class UnitePackaging implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;
    /**
     * Id de l'unité de packaging.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Longueur moyenne d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_MOYENNE = 50;
    /**
     * Libelle de l'unité de packaging.
     */
    @Column(name = "unite", nullable = false, length = LONGUEUR_MOYENNE)
    private String unite;

    /**
     * Liste des packaging ayant cette unité.
     */
    @OneToMany(mappedBy = "unite"  )
    private List<Packaging> packagings;
    /**
     * Liste des ingrédients ayant cette unité.
     */
    @OneToMany(mappedBy = "unite")
    private List<Ingredient> ingredients;

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
     * @return the unite
     */
    public String getUnite() {
        return unite;
    }
    /**
     * @param paramUnite the unite to set
     */
    public void setUnite(String paramUnite) {
        unite = paramUnite;
    }
    /**
     * @return the packagings
     */
    public List<Packaging> getPackagings() {
        return packagings;
    }
    /**
     * @param paramPackagings the packagings to set
     */
    public void setPackagings(List<Packaging> paramPackagings) {
        packagings = paramPackagings;
    }
    /**
     * Default constructor.
     */
    public UnitePackaging() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramUnite the unite to set
     */
    public UnitePackaging(Integer paramId, String paramUnite) {
        super();
        id = paramId;
        unite = paramUnite;
    }

}