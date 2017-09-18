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
 * Entité représentant une adresse.
 */
@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {

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
     * Grande longueur d'une chaine de caractère.
     */
    @Transient
    private static final int LONGUEUR_GRANDE = 150;
    /**
     * Id de l'adresse.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Numéro de voie de l'adresse.
     */
    @Column(name = "numero", nullable = true)
    private Integer numero;

    /**
     * Complément du numéro de la voie de l'adresse.
     */
    @Column(name = "complement_numero", nullable = true, length = LONGUEUR_PETITE)
    private String complementNumero;

    /**
     * Nom de la voie.
     */
    @Column(name = "voie", nullable = false, length = LONGUEUR_GRANDE)
    private String voie;

    /**
     * Longitude de l'adresse.
     */
    @Column(name = "longitude", nullable = false, length = LONGUEUR_PETITE)
    private String longitude;

    /**
     * Latitude de l'adresse.
     */
    @Column(name = "latitude", nullable = false, length = LONGUEUR_PETITE)
    private String latitude;


    /**
     * Liste d'adhérents résidant à cette adresse.
     */
    @OneToMany(mappedBy = "adresse")
    private List<Adherent> adherents;

    /**
     * Liste des commerces situés à cette adresse.
     */
    @OneToMany(mappedBy = "adresse")
    private List<Commerce> commerces;

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
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }


    /**
     * @param paramNumero the numero to set
     */
    public void setNumero(Integer paramNumero) {
        numero = paramNumero;
    }


    /**
     * @return the complementNumero
     */
    public String getComplementNumero() {
        return complementNumero;
    }


    /**
     * @param paramComplementNumero the complementNumero to set
     */
    public void setComplementNumero(String paramComplementNumero) {
        complementNumero = paramComplementNumero;
    }


    /**
     * @return the voie
     */
    public String getVoie() {
        return voie;
    }


    /**
     * @param paramVoie the voie to set
     */
    public void setVoie(String paramVoie) {
        voie = paramVoie;
    }


    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }


    /**
     * @param paramLongitude the longitude to set
     */
    public void setLongitude(String paramLongitude) {
        longitude = paramLongitude;
    }


    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }


    /**
     * @param paramLatitude the latitude to set
     */
    public void setLatitude(String paramLatitude) {
        latitude = paramLatitude;
    }


    /**
     * @return the adherents
     */
    public List<Adherent> getAdherents() {
        return adherents;
    }


    /**
     * @param paramAdherents the adherents to set
     */
    public void setAdherents(List<Adherent> paramAdherents) {
        adherents = paramAdherents;
    }


    /**
     * @return the commerces
     */
    public List<Commerce> getCommerces() {
        return commerces;
    }


    /**
     * @param paramCommerces the commerces to set
     */
    public void setCommerces(List<Commerce> paramCommerces) {
        commerces = paramCommerces;
    }


    /**
     * Default constructor.
     */
    public Adresse() {
    }

    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramNumero the numero to set
     * @param paramComplementNumero the complementNumero to set
     * @param paramVoie the voie to set
     * @param paramLongitude the longitude to set
     * @param paramLatitude the latitude to set
     */
    public Adresse(Integer paramId, Integer paramNumero, String paramComplementNumero, String paramVoie,
            String paramLongitude, String paramLatitude) {
        super();
        id = paramId;
        numero = paramNumero;
        complementNumero = paramComplementNumero;
        voie = paramVoie;
        longitude = paramLongitude;
        latitude = paramLatitude;
    }


}