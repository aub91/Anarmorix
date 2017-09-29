package fr.afcepf.anarmorix.controller;




import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;


/**
 * Classe contenant les fonctionnalités du controller des pages en lien avec la tournée.
 * @author Aubin
 *
 */
@SessionScoped
@ManagedBean(name = "mbTournee")
public class TourneeManagedBean {
    /**
     * Collection des point relais à visiter.
     */
    private List<CommerceVue> pointRelaisAVisiter = new ArrayList<>();
    /**
     * Collection des exploitation à visiter.
     */
    private List<CommerceVue> exploitationAVisiter = new ArrayList<>();
    /**
     * Classe contenant les méthodes à appeler.
     */
    @EJB
    private IBusinessLivreur busLivreur;
    /**
     * Classe contenant les méthodes à appeler.
     */
    @EJB
    private IBusinessMap busMap;
    /**
     * ManagedBean de connexion.
     */
    @ManagedProperty(value = "#{mbConnexion}")
    private ConnexionCommandeManagedBean cnxMb;
    /**
     * Livreur effectuant la tournée.
     */
    private Livreur livreur;
    /**
     * Message jSon représentant les WayPoints de l'itinéraire.
     */
    private StringBuilder jSonWayPoints = new StringBuilder("[");
    /**
     * Tournée selectionnée.
     */
    private Tournee selectedTournee;
    /**
     * Account twilio.
     */
    public static final String ACCOUNT_SID = "ACfe22176d0e37790f1e3b04ae13049393";
    /**
     * Token twilio.
     */
    public static final String AUTH_TOKEN = "87894586cd368fc7d4f478fa7eed9dbc";

    /**
     * Méthode pour set une tournée spécifique.
     */
    @PostConstruct
    public void setTournee() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String queryString = request.getQueryString();
        String[] tab = queryString.split("=");
        Integer idTournee = Integer.parseInt(tab[1]);
        selectedTournee = new Tournee(idTournee, null, null, null, null);
        livreur = (Livreur) cnxMb.getConnectedAdh();
        try {
            livreur = busLivreur.alimenterLivreur(livreur);
            selectedTournee = busLivreur.setLignesCommandes(selectedTournee);
            List<Exploitation> collectionExploitation = busLivreur.setExploitationAVisiter(selectedTournee);
            Set<PointRelais> collectionPointRelais = new LinkedHashSet<>();
            for (LigneCommande ligne : selectedTournee.getLignesCmd()) {
                boolean exist = false;
                for (PointRelais pointRelais : collectionPointRelais) {
                    if (pointRelais.getId() == ligne.getCommande().getRelais().getId()) {
                        exist = true;
                    }
                }
                if (!exist) {
                    collectionPointRelais.add(ligne.getCommande().getRelais());
                }
            }
            for (PointRelais pointRelais : collectionPointRelais) {
                CommerceVue commerce = new CommerceVue();
                commerce.setCommerce(pointRelais);
                for (LigneCommande ligne : selectedTournee.getLignesCmd()) {
                    if (ligne.getCommande().getRelais().getId() == pointRelais.getId()) {
                        commerce.getListeLigneCmd().add(ligne);
                    }
                }
                pointRelaisAVisiter.add(commerce);
            }
            for (Exploitation exploitation : collectionExploitation) {
                CommerceVue commerce = new CommerceVue();
                commerce.setCommerce(exploitation);
                for (LigneCommande ligne : selectedTournee.getLignesCmd()) {
                    if (ligne.getProduit().getCatalogues().get(0).getExploitation().getId() == exploitation.getId()) {
                        commerce.getListeLigneCmd().add(ligne);
                    }
                }
                exploitationAVisiter.add(commerce);
            }
            for (CommerceVue commerceVue : exploitationAVisiter) {
                jSonWayPoints.append("{location: {lat: ").append(commerceVue.getCommerce().getAdresse().getLatitude()).append(", lng: ")
                             .append(commerceVue.getCommerce().getAdresse().getLongitude()).append("}}, ");
            }
            for (CommerceVue commerceVue : pointRelaisAVisiter) {
                jSonWayPoints.append("{location: {lat: ").append(commerceVue.getCommerce().getAdresse().getLatitude()).append(", lng: ")
                             .append(commerceVue.getCommerce().getAdresse().getLongitude()).append("}}, ");
            }
            jSonWayPoints.delete(jSonWayPoints.length() - 2, jSonWayPoints.length()).append("]");
        } catch (AnarmorixException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * Méthode de mise à jour d'un produit récupéré.
     * @param ligne une ligne de commande venant d'être récupéré
     * @throws AnarmorixException une exception
     */
    public void recuperer(LigneCommande ligne) {
        ligne.setDateRetraitProducteur(new Date());
        try {
            busLivreur.mettreAJour(ligne);
            for (CommerceVue commerceVue : exploitationAVisiter) {
                if (commerceVue.getListeLigneCmd().contains(ligne)) {
                    commerceVue.getListeLigneCmd().remove(ligne);
                }
            }
        } catch (AnarmorixException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * Méthode de mise à jour de tous les produits récupérés dans une exploitation.
     * @param paramCommerceVue une exploitation où on récupère tous les produits
     * @throws AnarmorixException une exception
     */
    public void toutRecuperer(CommerceVue paramCommerceVue) {
        for (CommerceVue commerceVue : exploitationAVisiter) {
            if (commerceVue.equals(paramCommerceVue)) {
                for (LigneCommande ligne : commerceVue.getListeLigneCmd()) {
                    ligne.setDateRetraitProducteur(new Date());
                    try {
                        busLivreur.mettreAJour(ligne);
                    } catch (AnarmorixException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                commerceVue.getListeLigneCmd().clear();
            }
        }
    }
    /**
     * Méthode de mise à jour d'un produit déposé.
     * @param ligne une ligne de commande venant d'être récupéré
     * @throws AnarmorixException une exception
     */
    public void deposer(LigneCommande ligne) {
        ligne.setDateLivraisonPtRel(new Date());
        ligne.setQuantiteLivree(ligne.getQuantitePreparee());
        try {
            busLivreur.mettreAJour(ligne);
            for (CommerceVue commerceVue : pointRelaisAVisiter) {
                if (commerceVue.getListeLigneCmd().contains(ligne)) {
                    commerceVue.getListeLigneCmd().remove(ligne);
                }
            }
        } catch (AnarmorixException e) {
            e.printStackTrace();
        }
    }
    /**
     * Méthode de mise à jour de tous les produits déposés dans un point-relais.
     * @param paramCommerceVue un point-relais où on dépose tous les produits
     * @throws AnarmorixException une exception
     */
    public void toutDeposer(CommerceVue paramCommerceVue) {
        for (CommerceVue commerceVue : pointRelaisAVisiter) {
            if (commerceVue.equals(paramCommerceVue)) {
                for (LigneCommande ligne : commerceVue.getListeLigneCmd()) {
                    ligne.setDateLivraisonPtRel(new Date());
                    ligne.setQuantiteLivree(ligne.getQuantitePreparee());
                    Commande cmd = ligne.getCommande();
                    cmd.setStatut(Statut.EN_ATTENTE_DE_RETRAIT);
                    cmd.setCodeValidation("8392");
                    try {
                        busLivreur.mettreAJour(ligne);
                    } catch (AnarmorixException e) {
                        e.printStackTrace();
                    }
                }
                Commande cmd = commerceVue.getListeLigneCmd().get(0).getCommande();
                cmd.setStatut(Statut.EN_ATTENTE_DE_RETRAIT);
                Integer code = (int) (Math.random() * 10000);
                cmd.setCodeValidation(code.toString());
                try {
                    busLivreur.mettreAJour(cmd);
                } catch (AnarmorixException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                commerceVue.getListeLigneCmd().clear();
                StringBuffer sms = new StringBuffer();
                sms.append("Votre commande est prête. Vous pouvez aller la chercher au point-relais ").append(paramCommerceVue.getCommerce().getRaisonSociale())
                    .append(". Le code secret de votre commande est ").append(cmd.getCodeValidation()).append(". Merci de votre commande.");
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

                Message message = Message
                        .creator(new PhoneNumber("+33675332831"),  // to
                                 new PhoneNumber("+33757903069"),  // from
                                 sms.toString())
                        .create();
            }
        }
    }

    /**
     * @return the pointRelaisAVisiter
     */
    public List<CommerceVue> getPointRelaisAVisiter() {
        return pointRelaisAVisiter;
    }
    /**
     * @param paramPointRelaisAVisiter the pointRelaisAVisiter to set
     */
    public void setPointRelaisAVisiter(List<CommerceVue> paramPointRelaisAVisiter) {
        pointRelaisAVisiter = paramPointRelaisAVisiter;
    }

    /**
     * @return the exploitationAVisiter
     */
    public List<CommerceVue> getExploitationAVisiter() {
        return exploitationAVisiter;
    }
    /**
     * @param paramExploitationAVisiter the exploitationAVisiter to set
     */
    public void setExploitationAVisiter(List<CommerceVue> paramExploitationAVisiter) {
        exploitationAVisiter = paramExploitationAVisiter;
    }
    /**
     * @return the busLivreur
     */
    public IBusinessLivreur getBusLivreur() {
        return busLivreur;
    }
    /**
     * @param paramBusLivreur the busLivreur to set
     */
    public void setBusLivreur(IBusinessLivreur paramBusLivreur) {
        busLivreur = paramBusLivreur;
    }
    /**
     * @return the selectedTournee
     */
    public Tournee getSelectedTournee() {
        return selectedTournee;
    }
    /**
     * @param paramSelectedTournee the selectedTournee to set
     */
    public void setSelectedTournee(Tournee paramSelectedTournee) {
        selectedTournee = paramSelectedTournee;
    }
    /**
     * @return the jSonWayPoints
     */
    public StringBuilder getjSonWayPoints() {
        return jSonWayPoints;
    }
    /**
     * @param paramJSonWayPoints the jSonWayPoints to set
     */
    public void setjSonWayPoints(StringBuilder paramJSonWayPoints) {
        jSonWayPoints = paramJSonWayPoints;
    }

    /**
     * @return the cnxMb
     */
    public ConnexionCommandeManagedBean getCnxMb() {
        return cnxMb;
    }

    /**
     * @param paramCnxMb the cnxMb to set
     */
    public void setCnxMb(ConnexionCommandeManagedBean paramCnxMb) {
        cnxMb = paramCnxMb;
    }

    /**
     * @return the livreur
     */
    public Livreur getLivreur() {
        return livreur;
    }

    /**
     * @param paramLivreur the livreur to set
     */
    public void setLivreur(Livreur paramLivreur) {
        livreur = paramLivreur;
    }
}
