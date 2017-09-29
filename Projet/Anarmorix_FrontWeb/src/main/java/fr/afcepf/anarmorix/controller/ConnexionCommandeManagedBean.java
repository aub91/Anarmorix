package fr.afcepf.anarmorix.controller;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.anarmorix.business.api.IBusinessConnexion;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Employe;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.Producteur;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * ManagedBean avec les fonctionnalités de connexion.
 * @author Aubin
 *
 */
@ManagedBean(name = "mbConnexion")
@SessionScoped
public class ConnexionCommandeManagedBean {
    /**
     * {@link IBusinessConnexion}.
     */
    @EJB
    private IBusinessConnexion buCnx;
    /**
     * L'Adhérent connecté.
     */
    private Adherent connectedAdh;
    /**
     * Nom d'utilisateur.
     */
    private String username = "";
    /**
     * Mot de passe.
     */
    private String password = "";


    /**
     * Méthode de connexion.
     * @return chemin de redirection
     */
    public String connexion() {
        String forward = "/pageConnexionCommande.xhml?faces-redirect=true";
        try {
            connectedAdh = buCnx.seConnecter(username, password);
            if (connectedAdh != null && connectedAdh.getClass() == Livreur.class) {
                forward = "/tableauDeBordLivreur.xhtml?faces-redirect=true";
            } else {
                if (connectedAdh != null && connectedAdh.getClass() == Employe.class) {
                    forward = "/tableauBordPointRelais.jsf?faces-redirect=true";
                } else {
                    if (connectedAdh != null && connectedAdh.getClass() == Producteur.class) {
                        forward = "/tableauBordProducteur.jsf?faces-redirect=true";
                    } else {
                        if (connectedAdh != null && connectedAdh.getClass() == Client.class) {
                            forward = "/pageAccueilAnarmoriqueMap.jsf?faces-redirect=true";
                        }
                    }
                }
            }
            return forward;
        } catch (AnarmorixException e) {
            forward = "/pageConnexionCommande.xhtml?faces-redirect=true";
            return forward;
        }
    }
    /**
     * Méthode de connexion depuis page de connexion.
     * @return chemin de redirection
     */
    public String seConnecter() {
        String forward = "";
        try {
            connectedAdh = buCnx.seConnecter(username, password);
            if (connectedAdh != null && connectedAdh.getClass() == Client.class) {
                forward = "/paiement.xhtml?faces-redirect=true";
            } else {
                forward = "/pageConnexionCommande.xhml?faces-redirect=true";
            }
            return forward;
        } catch (AnarmorixException e) {
            forward = "/pageConnexionCommande.xhtml?faces-redirect=true";
            return forward;
        }
    }
    /**
     * Méthode de redirection vers la page de paiement.
     */
    private void redirectPaiement() {
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler)
                FacesContext.getCurrentInstance()
                .getApplication()
                .getNavigationHandler();
        nav.performNavigation("/pagePaiement.xhtml?faces-redirect=true");
    }
    /**
     * Méthode de vérification si présence d'un utilisateur connecté.
     */
    public void verifNonConnecte() {
        if (connectedAdh != null) {
            redirectPaiement();
        }
    }
    /**
     * @return the buCnx
     */
    public IBusinessConnexion getBuCnx() {
        return buCnx;
    }

    /**
     * @param paramBuCnx the buCnx to set
     */
    public void setBuCnx(IBusinessConnexion paramBuCnx) {
        buCnx = paramBuCnx;
    }

    /**
     * @return the connectedAdh
     */
    public Adherent getConnectedAdh() {
        return connectedAdh;
    }

    /**
     * @param paramConnectedAdh the connectedAdh to set
     */
    public void setConnectedAdh(Adherent paramConnectedAdh) {
        connectedAdh = paramConnectedAdh;
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

}
