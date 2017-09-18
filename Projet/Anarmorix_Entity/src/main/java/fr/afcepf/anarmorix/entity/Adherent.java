package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity représentant un adhérent à Anarmorix.
 */
@Entity
@Table(name = "adherent")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_adherent")

public abstract class Adherent implements Serializable {

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
     * Petite longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_PETITE = 20;
    /**
     * Grande longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_GRANDE = 150;
    /**
     * Id de l'adhérent.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Date d'inscription de l'adhérent.
     */
    @Column(name = "dateInscription", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;

    /**
     * Nom de l'adhérent.
     */
    @Column(name = "nom", nullable = false, length = LONGUEUR_MOYENNE)
    private String nom;

    /**
     * Prénom de l'adhérent.
     */
    @Column(name = "prenom", nullable = false, length = LONGUEUR_MOYENNE)
    private String prenom;

    /**
     * Date de naissance de l'adhérent.
     */
    @Column(name = "dateNaissance", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    /**
     * Adresse de l'adhérent.
     */
    @ManyToOne
    @JoinColumn(name = "id_adresse", nullable = false, foreignKey = @ForeignKey(name = "FK_Adherent_Adresse"))
    private Adresse adresse;
    /**
     * Adresse e-mail de l'adhérent.
     */
    @Column(name = "mail", nullable = false, length = LONGUEUR_GRANDE)
    private String mail;

    /**
     * Numéro de téléphone principal de l'adhérent.
     */
    @Column(name = "tel1", nullable = false, length = LONGUEUR_PETITE)
    private String telephone1;

    /**
     * Numéro de téléphone alternatif de l'adhérent.
     */
    @Column(name = "tel2", nullable = false, length = LONGUEUR_PETITE)
    private String telephone2;

    /**
     * Username de l'adhérent.
     */
    @Column(name = "username", nullable = false, length = LONGUEUR_MOYENNE)
    private String username;

    /**
     * Mot de passe de l'adhérent.
     */
    @Column(name = "password", nullable = false, length = LONGUEUR_PETITE)
    private String password;

    /**
     * Date de désinscription de l'adhérent.
     */
    @Column(name = "dateDesinscription", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDesinscription;


    /**
     * Motif de désinscription de l'adhérent.
     */
    @ManyToOne
    @JoinColumn(name = "id_motif_desinscription", nullable = true, foreignKey = @ForeignKey(name = "FK_Adherent_Desinscription"))
    private MotifDesinscription motifDesinscription;

    /**
     * Image de profil de l'adhérent.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_image", nullable = true, foreignKey = @ForeignKey(name = "FK_Adherent_Image"))
    private Image image;

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
     * @return the dateInscription
     */
    public Date getDateInscription() {
        return dateInscription;
    }

    /**
     * @param paramDateInscription the dateInscription to set
     */
    public void setDateInscription(Date paramDateInscription) {
        dateInscription = paramDateInscription;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param paramPrenom the prenom to set
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param paramDateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date paramDateNaissance) {
        dateNaissance = paramDateNaissance;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param paramMail the mail to set
     */
    public void setMail(String paramMail) {
        mail = paramMail;
    }

    /**
     * @return the telephone1
     */
    public String getTelephone1() {
        return telephone1;
    }

    /**
     * @param paramTelephone1 the telephone1 to set
     */
    public void setTelephone1(String paramTelephone1) {
        telephone1 = paramTelephone1;
    }

    /**
     * @return the telephone2
     */
    public String getTelephone2() {
        return telephone2;
    }

    /**
     * @param paramTelephone2 the telephone2 to set
     */
    public void setTelephone2(String paramTelephone2) {
        telephone2 = paramTelephone2;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param paramUsername the username to set
     */
    public void setUsername(String paramUsername) {
        username = paramUsername;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param paramPassword the password to set
     */
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }

    /**
     * @return the dateDesinscription
     */
    public Date getDateDesinscription() {
        return dateDesinscription;
    }

    /**
     * @param paramDateDesinscription the dateDesinscription to set
     */
    public void setDateDesinscription(Date paramDateDesinscription) {
        dateDesinscription = paramDateDesinscription;
    }

    /**
     * @return the motifDesinscription
     */
    public MotifDesinscription getMotifDesinscription() {
        return motifDesinscription;
    }

    /**
     * @param paramMotifDesinscription the motifDesinscription to set
     */
    public void setMotifDesinscription(MotifDesinscription paramMotifDesinscription) {
        motifDesinscription = paramMotifDesinscription;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param paramImage the image to set
     */
    public void setImage(Image paramImage) {
        image = paramImage;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * @param paramAdresse the adresse to set
     */
    public void setAdresse(Adresse paramAdresse) {
        adresse = paramAdresse;
    }

    /**
     * Default constructor.
     */
    public Adherent() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramDateInscription the dateInscription to set
     * @param paramNom the nom to set
     * @param paramPrenom the prenom to set
     * @param paramDateNaissance the dateNaissance to set
     * @param paramAdresse the adresse to set
     * @param paramMail the mail to set
     * @param paramTelephone1 the telephone1 to set
     * @param paramTelephone2 the telephone2 to set
     * @param paramUsername the username to set
     * @param paramPassword the password to set
     * @param paramImage the image to set
     */
    public Adherent(Integer paramId, Date paramDateInscription, String paramNom, String paramPrenom,
            Date paramDateNaissance, Adresse paramAdresse, String paramMail, String paramTelephone1, String paramTelephone2,
            String paramUsername, String paramPassword, Image paramImage) {
        super();
        id = paramId;
        dateInscription = paramDateInscription;
        nom = paramNom;
        prenom = paramPrenom;
        dateNaissance = paramDateNaissance;
        adresse = paramAdresse;
        mail = paramMail;
        telephone1 = paramTelephone1;
        telephone2 = paramTelephone2;
        username = paramUsername;
        password = paramPassword;
        image = paramImage;
    }
}