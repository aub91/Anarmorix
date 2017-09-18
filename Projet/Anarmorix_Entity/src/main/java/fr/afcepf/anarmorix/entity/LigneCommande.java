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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant une ligne de commande.
 */
@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;


    /**
     * Id de la ligne de commande.
     */
    @Id
    @Column(name = " id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Commande associée à la ligne.
     */
    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false, foreignKey = @ForeignKey(name = "FK_LigneCommande_Commande"))
    private Commande commande;
    /**
     * Quantite commandée indiquée dans la ligne de commande.
     */
    @Column(name = "quantite_commandee", nullable = false)
    private Double quantiteCommandee;

    /**
     * Quantite préparée indiquée dans la ligne de commande.
     */
    @Column(name = "quantite_preparee", nullable = true)
    private Double quantitePreparee;

    /**
     * Quantite livrée indiquée dans la ligne de commande.
     */
    @Column(name = "quantite_livree", nullable = true)
    private Double quantiteLivree;

    /**
     * Quantite délivrée indiquée dans la ligne de commande.
     */
    @Column(name = "quantite_delivree", nullable = true)
    private Double quantiteDelivree;

    /**
     * Date de début de préparation de la ligne de commande.
     */
    @Column(name = "dateDebutPreparation", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebutPreparation;

    /**
     * Date de fin de préparation de la ligne de commande.
     */
    @Column(name = "dateFinPreparation", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinPreparation;

    /**
     * Date de retrait de la ligne de commande chez me producteur.
     */
    @Column(name = "dateRetraitProducteur", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetraitProducteur;

    /**
     * Date de livraison de la ligne de commande au point-relais.
     */
    @Column(name = "dateLivraisonPtRel", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLivraisonPtRel;

    /**
     * Date de retrait de la ligne de commande au point-relais.
     */
    @Column(name = "dateRetraitPtRel", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetraitPtRel;

    /**
     * Produit contenu dans la ligne de commande.
     */
    @ManyToOne
    @JoinColumn(name = "id_produit", nullable = false, foreignKey = @ForeignKey(name = "FK_LigneCommande_Produit"))
    private Produit produit;

    /**
     * Aleas subis par la ligne de commande.
     */
    @ManyToMany(mappedBy = "lignesCmd")
    private List<Alea> aleas;

    /**
     * Tournée prenant en charge la ligne de commande.
     */
    @ManyToOne
    @JoinColumn(name = "id_tournee", nullable = true, foreignKey = @ForeignKey(name = "FK_LigneCommande_Tournee"))
    private Tournee tournee;

    /**
     * Default constructor.
     */
    public LigneCommande() {
    }

    /**
     * Constructeur surcahrgé.
     * @param paramId the id to set
     * @param paramQuantiteCommandee the quantiteCommandee to set
     * @param paramQuantitePreparee the quantitePreparee to set
     * @param paramQuantiteLivree the quantiteLivree to set
     * @param paramQuantiteDelivree the quantiteDelivree to set
     * @param paramDateDebutPreparation the dateDebutPreparation to set
     * @param paramDateFinPreparation the DateFinPreparation to set
     * @param paramDateRetraitProducteur the dateRetraitProducteur to set
     * @param paramDateLivraisonPtRel the dateLivraisonPtRel to set
     * @param paramDateRetraitPtRel the dateRetraitPtRel to set
     * @param paramProduit the produit to set
     * @param paramTournee the tournee to set
     */
    public LigneCommande(Integer paramId, Double paramQuantiteCommandee, Double paramQuantitePreparee,
            Double paramQuantiteLivree, Double paramQuantiteDelivree, Date paramDateDebutPreparation,
            Date paramDateFinPreparation, Date paramDateRetraitProducteur, Date paramDateLivraisonPtRel,
            Date paramDateRetraitPtRel, Produit paramProduit, Tournee paramTournee) {
        super();
        id = paramId;
        quantiteCommandee = paramQuantiteCommandee;
        quantitePreparee = paramQuantitePreparee;
        quantiteLivree = paramQuantiteLivree;
        quantiteDelivree = paramQuantiteDelivree;
        dateDebutPreparation = paramDateDebutPreparation;
        dateFinPreparation = paramDateFinPreparation;
        dateRetraitProducteur = paramDateRetraitProducteur;
        dateLivraisonPtRel = paramDateLivraisonPtRel;
        dateRetraitPtRel = paramDateRetraitPtRel;
        produit = paramProduit;
        tournee = paramTournee;
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
     * @return the quantiteCommandee
     */
    public Double getQuantiteCommandee() {
        return quantiteCommandee;
    }

    /**
     * @param paramQuantiteCommandee the quantiteCommandee to set
     */
    public void setQuantiteCommandee(Double paramQuantiteCommandee) {
        quantiteCommandee = paramQuantiteCommandee;
    }

    /**
     * @return the quantitePreparee
     */
    public Double getQuantitePreparee() {
        return quantitePreparee;
    }

    /**
     * @param paramQuantitePreparee the quantitePreparee to set
     */
    public void setQuantitePreparee(Double paramQuantitePreparee) {
        quantitePreparee = paramQuantitePreparee;
    }

    /**
     * @return the quantiteLivree
     */
    public Double getQuantiteLivree() {
        return quantiteLivree;
    }

    /**
     * @param paramQuantiteLivree the quantiteLivree to set
     */
    public void setQuantiteLivree(Double paramQuantiteLivree) {
        quantiteLivree = paramQuantiteLivree;
    }

    /**
     * @return the quantiteDelivree
     */
    public Double getQuantiteDelivree() {
        return quantiteDelivree;
    }

    /**
     * @param paramQuantiteDelivree the quantiteDelivree to set
     */
    public void setQuantiteDelivree(Double paramQuantiteDelivree) {
        quantiteDelivree = paramQuantiteDelivree;
    }

    /**
     * @return the dateDebutPreparation
     */
    public Date getDateDebutPreparation() {
        return dateDebutPreparation;
    }

    /**
     * @param paramDateDebutPreparation the dateDebutPreparation to set
     */
    public void setDateDebutPreparation(Date paramDateDebutPreparation) {
        dateDebutPreparation = paramDateDebutPreparation;
    }

    /**
     * @return the dateFinPreparation
     */
    public Date getDateFinPreparation() {
        return dateFinPreparation;
    }

    /**
     * @param paramDateFinPreparation the dateFinPreparation to set
     */
    public void setDateFinPreparation(Date paramDateFinPreparation) {
        dateFinPreparation = paramDateFinPreparation;
    }

    /**
     * @return the dateRetraitProducteur
     */
    public Date getDateRetraitProducteur() {
        return dateRetraitProducteur;
    }

    /**
     * @param paramDateRetraitProducteur the dateRetraitProducteur to set
     */
    public void setDateRetraitProducteur(Date paramDateRetraitProducteur) {
        dateRetraitProducteur = paramDateRetraitProducteur;
    }

    /**
     * @return the dateLivraisonPtRel
     */
    public Date getDateLivraisonPtRel() {
        return dateLivraisonPtRel;
    }

    /**
     * @param paramDateLivraisonPtRel the dateLivraisonPtRel to set
     */
    public void setDateLivraisonPtRel(Date paramDateLivraisonPtRel) {
        dateLivraisonPtRel = paramDateLivraisonPtRel;
    }

    /**
     * @return the dateRetraitPtRel
     */
    public Date getDateRetraitPtRel() {
        return dateRetraitPtRel;
    }

    /**
     * @param paramDateRetraitPtRel the dateRetraitPtRel to set
     */
    public void setDateRetraitPtRel(Date paramDateRetraitPtRel) {
        dateRetraitPtRel = paramDateRetraitPtRel;
    }

    /**
     * @return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param paramProduit the produit to set
     */
    public void setProduit(Produit paramProduit) {
        produit = paramProduit;
    }

    /**
     * @return the aleas
     */
    public List<Alea> getAleas() {
        return aleas;
    }

    /**
     * @param paramAleas the aleas to set
     */
    public void setAleas(List<Alea> paramAleas) {
        aleas = paramAleas;
    }

    /**
     * @return the tournee
     */
    public Tournee getTournee() {
        return tournee;
    }

    /**
     * @param paramTournee the tournee to set
     */
    public void setTournee(Tournee paramTournee) {
        tournee = paramTournee;
    }

}