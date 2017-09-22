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

/**
 * Entité représentant un taux de TVA.
 */
@Entity
@Table(name = "tauxTva")
public class TauxTVA implements Serializable {

    /**
     * Numéro pour la sérialisation.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id de l'adhérent.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * La valeur du taux de tva.
     */
    @Column(name = "taux", nullable = false, columnDefinition = "DECIMAL(12,2)")
    private Double taux;

    /**
     * Liste des produits ayant ce taux de TVA.
     */
    @OneToMany(mappedBy = "tva")
    private List<TypeProduit> produits;

    /**
     * Default constructor.
     */
    public TauxTVA() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramTaux the taux to set
     */
    public TauxTVA(Integer paramId, Double paramTaux) {
        super();
        id = paramId;
        taux = paramTaux;
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
     * @return the taux
     */
    public Double getTaux() {
        return taux;
    }

    /**
     * @param paramTaux the taux to set
     */
    public void setTaux(Double paramTaux) {
        taux = paramTaux;
    }

    /**
     * @return the produits
     */
    public List<TypeProduit> getProduits() {
        return produits;
    }

    /**
     * @param paramProduits the produits to set
     */
    public void setProduits(List<TypeProduit> paramProduits) {
        produits = paramProduits;
    }

}