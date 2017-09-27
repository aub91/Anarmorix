package fr.afcepf.anarmorix.controller;




import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.PointRelais;
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
     * Méthode pour set une tournée spécifique.
     */
    @PostConstruct
    public void setTournee() {
        selectedTournee = new Tournee(1, null, null, null, null);
        livreur = (Livreur) cnxMb.getConnectedAdh();
        try {
            livreur = busLivreur.alimenterLivreur(livreur);
            selectedTournee = busLivreur.setLignesCommandes(selectedTournee);
            List<Exploitation> collectionExploitation = busLivreur.setExploitationAVisiter(selectedTournee);
            Set<PointRelais> collectionPointRelais = new LinkedHashSet<>();
            for (LigneCommande ligne : selectedTournee.getLignesCmd()) {
                collectionPointRelais.add(ligne.getCommande().getRelais());
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
