package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité contenant le chemin vers une image.
 */
@Entity
@Table(name = "image")
public class Image implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Grande longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_GRANDE = 150;

    /**
     * Id de l'image.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Chemin de l'image.
     */
    @Column(name = "chemin", nullable = false, length = LONGUEUR_GRANDE)
    private String chemin;

    /**
     * Liste de produits associés à l'image.
     */
    @OneToMany(mappedBy = "image")
    private List<Produit> produits;

    /**
     * Commerce associé à l'image.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commerce", nullable = true, foreignKey = @ForeignKey(name = "FK_Image_Commerce"))
    private Commerce commerce;

    /**
     * Exploitation associée à l'image.
     */
    @ManyToOne
    @JoinColumn(name = "id_exploitation", nullable = true, foreignKey = @ForeignKey(name = "FK_Image_Exploitation"))

    private Exploitation exploitation;

    /**
     * Liste de produits types associés à l'image.
     */
    @OneToMany(mappedBy = "imageParDefaut")
    private List<TypeProduit> typesProduits;

    /**
     * Adhérent associé à l'image.
     */
    @OneToOne
    @JoinColumn(name = "id_adherent", nullable = true, foreignKey = @ForeignKey(name = "FK_Image_Adherent"))
    private Adherent adherent;

    /**
     * Default constructor.
     */
    public Image() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set.
     * @param paramChemin the chemin to set.
     * @param paramCommerce the commerce to set.
     * @param paramExploitation the exploitation to set.
     * @param paramAdherent the adherent to set.
     */
    public Image(Integer paramId, String paramChemin, Commerce paramCommerce, Exploitation paramExploitation,
            Adherent paramAdherent) {
        super();
        id = paramId;
        chemin = paramChemin;
        commerce = paramCommerce;
        exploitation = paramExploitation;
        adherent = paramAdherent;
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
     * @return the chemin
     */
    public String getChemin() {
        return chemin;
    }

    /**
     * @param paramChemin the chemin to set
     */
    public void setChemin(String paramChemin) {
        chemin = paramChemin;
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
     * @return the commerce
     */
    public Commerce getCommerce() {
        return commerce;
    }

    /**
     * @param paramCommerce the commerce to set
     */
    public void setCommerce(Commerce paramCommerce) {
        commerce = paramCommerce;
    }

    /**
     * @return the exploitation
     */
    public Exploitation getExploitation() {
        return exploitation;
    }

    /**
     * @param paramExploitation the exploitation to set
     */
    public void setExploitation(Exploitation paramExploitation) {
        exploitation = paramExploitation;
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

    /**
     * @return the adherent
     */
    public Adherent getAdherent() {
        return adherent;
    }

    /**
     * @param paramAdherent the adherent to set
     */
    public void setAdherent(Adherent paramAdherent) {
        adherent = paramAdherent;
    }
}