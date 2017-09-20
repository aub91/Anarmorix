package fr.afcepf.anarmorix.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entité représentant un client héritant de {@link Adherent}.
 */
@Entity
@DiscriminatorValue("Client")
public class Client extends Adherent {

    /**
     * Numéro pour la sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Client() {
    }

    /**
     * Liste de commandes du client.
     */
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    /**
     * @return the commandes
     */
    public List<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param paramCommandes the commandes to set
     */
    public void setCommandes(List<Commande> paramCommandes) {
        commandes = paramCommandes;
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
    public Client(Integer paramId, Date paramDateInscription, String paramNom, String paramPrenom,
            Date paramDateNaissance, Adresse paramAdresse, String paramMail, String paramTelephone1,
            String paramTelephone2, String paramUsername, String paramPassword, Image paramImage) {
        super(paramId, paramDateInscription, paramNom, paramPrenom, paramDateNaissance, paramAdresse, paramMail,
                paramTelephone1, paramTelephone2, paramUsername, paramPassword, paramImage);
    }

}