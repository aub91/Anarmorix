package fr.afcepf.anarmorix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entité représentant un horaire.
 */
@Entity
@Table(name = "horaire")
public class Horaire implements Serializable {

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
     * Id de l'horaire.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Libellé de l'horaire.
     */
    @Column(name = "libelle", nullable = false, length = LONGUEUR_MOYENNE)
    private String libelle;

    /**
     * Heure d'ouverture.
     */
    @Column(name = "heureOuverture", nullable = false, length = LONGUEUR_PETITE)
    private String heureOuverture;

    /**
     * Heure de fermeture.
     */
    @Column(name = "heureFermeture", nullable = false, length = LONGUEUR_PETITE)
    private String heureFermeture;

    /**
     * Jour d'ouverture.
     */
    @ManyToOne
    @JoinColumn(name = "id_jour", nullable = false, foreignKey = @ForeignKey(name = "FK_Horaire_Jour"))
    private JourOuverture jour;

    /**
     * Default constructor.
     */
    public Horaire() {
    }
    /**
     * Constructeur surchargé.
     * @param paramId the id to set
     * @param paramLibelle the libelle to set
     * @param paramHeureOuverture the heureOuverture to set
     * @param paramHeureFermeture the heureFermeture to set
     * @param paramJour the jour to set
     */
    public Horaire(Integer paramId, String paramLibelle, String paramHeureOuverture, String paramHeureFermeture,
            JourOuverture paramJour) {
        super();
        id = paramId;
        libelle = paramLibelle;
        heureOuverture = paramHeureOuverture;
        heureFermeture = paramHeureFermeture;
        jour = paramJour;
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
     * @return the heureOuverture
     */
    public String getHeureOuverture() {
        return heureOuverture;
    }
    /**
     * @param paramHeureOuverture the heureOuverture to set
     */
    public void setHeureOuverture(String paramHeureOuverture) {
        heureOuverture = paramHeureOuverture;
    }
    /**
     * @return the heureFermeture
     */
    public String getHeureFermeture() {
        return heureFermeture;
    }
    /**
     * @param paramHeureFermeture the heureFermeture to set
     */
    public void setHeureFermeture(String paramHeureFermeture) {
        heureFermeture = paramHeureFermeture;
    }
    /**
     * @return the jour
     */
    public JourOuverture getJour() {
        return jour;
    }
    /**
     * @param paramJour the jour to set
     */
    public void setJour(JourOuverture paramJour) {
        jour = paramJour;
    }

}