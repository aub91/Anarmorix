package fr.afcepf.anarmorix.entity;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant un commerce.
 */
@Entity
@Table(name = "commerce")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_commerce")
public abstract class Commerce implements Serializable {

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
     * Longueur moyenne d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_MOYENNE = 50;

    /**
     * Id du commerce.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Numéro Siren du commerce.
     */
    @Column(name = "numSiren", nullable = false, length = LONGUEUR_PETITE)
    private String numSiren;

    /**
     * Numéro NIC du commerce.
     */
    @Column(name = "numNic", nullable = false, length = LONGUEUR_PETITE)
    private String numNic;

    /**
     * Code APE du commerce.
     */
    @Column(name = "codeApe", nullable = false, length = LONGUEUR_PETITE)
    private String codeApe;
    /**
     * Numéro IBAN de la société.
     */
    @Column(name = "iban", nullable = true, length = LONGUEUR_PETITE)
    private String iban;

    /**
     * Raison sociale du commerce.
     */
    @Column(name = "raisonSociale", nullable = false, length = LONGUEUR_MOYENNE)
    private String raisonSociale;

    /**
     * Adresse du commerce.
     */
    @ManyToOne
    @JoinColumn(name = "id_adresse", nullable = false, foreignKey = @ForeignKey(name = "FK_Commerce_Adresse"))
    private Adresse adresse;

    /**
     * Liste des indisponibilités du commerce.
     */
    @OneToMany(mappedBy = "commerce")
    private List<Indisponibilite> indisponiblites;

    /**
     * Image principale du commerce.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_image", nullable = true, foreignKey = @ForeignKey(name = "FK_Commerce_Image"))
    private Image imagePrincipale;
    /**
     * Default constructor.
     */
    public Commerce() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramNumSiren the numSiren to set
     * @param paramNumNic the numNic to set
     * @param paramCodeApe the codeApe to set
     * @param paramIban the iban to set
     * @param paramRaisonSociale the raisonSociale to set
     * @param paramAdresse the adresse to set
     * @param paramImagePrincipale the imagePrincipale to set
     */
    public Commerce(Integer paramId, String paramNumSiren, String paramNumNic, String paramCodeApe,
            String paramIban, String paramRaisonSociale, Adresse paramAdresse, Image paramImagePrincipale) {
        super();
        id = paramId;
        numSiren = paramNumSiren;
        numNic = paramNumNic;
        codeApe = paramCodeApe;
        iban = paramIban;
        raisonSociale = paramRaisonSociale;
        adresse = paramAdresse;
        imagePrincipale = paramImagePrincipale;
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
     * @return the numSiren
     */
    public String getNumSiren() {
        return numSiren;
    }
    /**
     * @param paramNumSiren the numSiren to set
     */
    public void setNumSiren(String paramNumSiren) {
        numSiren = paramNumSiren;
    }
    /**
     * @return the numNic
     */
    public String getNumNic() {
        return numNic;
    }
    /**
     * @param paramNumNic the numNic to set
     */
    public void setNumNic(String paramNumNic) {
        numNic = paramNumNic;
    }
    /**
     * @return the codeApe
     */
    public String getCodeApe() {
        return codeApe;
    }
    /**
     * @param paramCodeApe the codeApe to set
     */
    public void setCodeApe(String paramCodeApe) {
        codeApe = paramCodeApe;
    }
    /**
     * @return the raisonSociale
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }
    /**
     * @param paramRaisonSociale the raisonSociale to set
     */
    public void setRaisonSociale(String paramRaisonSociale) {
        raisonSociale = paramRaisonSociale;
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
     * @return the indisponiblites
     */
    public List<Indisponibilite> getIndisponiblites() {
        return indisponiblites;
    }
    /**
     * @param paramIndisponiblites the indisponiblites to set
     */
    public void setIndisponiblites(List<Indisponibilite> paramIndisponiblites) {
        indisponiblites = paramIndisponiblites;
    }
    /**
     * @return the imagePrincipale
     */
    public Image getImagePrincipale() {
        return imagePrincipale;
    }
    /**
     * @param paramImagePrincipale the imagePrincipale to set
     */
    public void setImagePrincipale(Image paramImagePrincipale) {
        imagePrincipale = paramImagePrincipale;
    }
    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }
    /**
     * @param paramIban the iban to set
     */
    public void setIban(String paramIban) {
        iban = paramIban;
    }

}