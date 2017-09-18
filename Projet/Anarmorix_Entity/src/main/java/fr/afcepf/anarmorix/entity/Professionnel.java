package fr.afcepf.anarmorix.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Entité représentant un professionnel.
 */
@Entity
@DiscriminatorValue("Professionnel")
@DiscriminatorColumn(name = "type_professionnel")
public abstract class Professionnel extends Adherent {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Professionnel() {
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
    public Professionnel(Integer paramId, Date paramDateInscription, String paramNom, String paramPrenom,
            Date paramDateNaissance, Adresse paramAdresse, String paramMail, String paramTelephone1,
            String paramTelephone2, String paramUsername, String paramPassword, Image paramImage) {
        super(paramId, paramDateInscription, paramNom, paramPrenom, paramDateNaissance, paramAdresse, paramMail,
                paramTelephone1, paramTelephone2, paramUsername, paramPassword, paramImage);
    }

}