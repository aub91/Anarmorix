package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entité représentant une commande cliente.
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
    * Petite longueur d'une chaine de caractère.
    */
   @Transient
   private static final int LONGUEUR_PETITE = 20;

    /**
     * Id de la commande.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Date de création de la commande.
     */
    @Column(name = "dateCreation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    /**
     * Date de validation de la commande.
     */
    @Column(name = "dateValidation", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValidation;

    /**
     * Code de validation de la commande.
     */
    @Column(name = "codeValidation", nullable = true, length = LONGUEUR_PETITE)
    private String codeValidation;


    /**
     * Point-relais de retrait de la commande.
     */
    @ManyToOne
    @JoinColumn(name = "id_relais", nullable = false, foreignKey = @ForeignKey(name = "FK_Commande_Relais"))
    private PointRelais relais;

    /**
     * Client ayant passé la commande.
     */
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name = "FK_Commande_Client"))
    private Client client;
    /**
     * Liste des lignes de commande.
     */
    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> lignesCommande;
    /**
     * Statut de la commande.
     */
    @Enumerated(EnumType.STRING)
    private Statut statut;

    /**
     * Default constructor.
     */
    public Commande() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDateCreation the dateCreation to set
     * @param paramDateValidation the dateValidation to set
     * @param paramCodeValidation the codeValidation to set
     * @param paramRelais the relais to set
     * @param paramClient the client to set
     * @param paramStatut the statut to set
     */
    public Commande(Integer paramId, Date paramDateCreation, Date paramDateValidation, String paramCodeValidation,
            PointRelais paramRelais, Client paramClient, Statut paramStatut) {
        super();
        id = paramId;
        dateCreation = paramDateCreation;
        dateValidation = paramDateValidation;
        codeValidation = paramCodeValidation;
        relais = paramRelais;
        client = paramClient;
        statut = paramStatut;
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
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }
    /**
     * @param paramDateCreation the dateCreation to set
     */
    public void setDateCreation(Date paramDateCreation) {
        dateCreation = paramDateCreation;
    }
    /**
     * @return the dateValidation
     */
    public Date getDateValidation() {
        return dateValidation;
    }
    /**
     * @param paramDateValidation the dateValidation to set
     */
    public void setDateValidation(Date paramDateValidation) {
        dateValidation = paramDateValidation;
    }
    /**
     * @return the codeValidation
     */
    public String getCodeValidation() {
        return codeValidation;
    }
    /**
     * @param paramCodeValidation the codeValidation to set
     */
    public void setCodeValidation(String paramCodeValidation) {
        codeValidation = paramCodeValidation;
    }
    /**
     * @return the relais
     */
    public PointRelais getRelais() {
        return relais;
    }
    /**
     * @param paramRelais the relais to set
     */
    public void setRelais(PointRelais paramRelais) {
        relais = paramRelais;
    }
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }
    /**
     * @param paramClient the client to set
     */
    public void setClient(Client paramClient) {
        client = paramClient;
    }
    /**
     * @return the statut
     */
    public Statut getStatut() {
        return statut;
    }
    /**
     * @param paramStatut the statut to set
     */
    public void setStatut(Statut paramStatut) {
        statut = paramStatut;
    }
    /**
     * @return the lignesCommande
     */
    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }
    /**
     * @param paramLignesCommande the lignesCommande to set
     */
    public void setLignesCommande(List<LigneCommande> paramLignesCommande) {
        lignesCommande = paramLignesCommande;
    }
}