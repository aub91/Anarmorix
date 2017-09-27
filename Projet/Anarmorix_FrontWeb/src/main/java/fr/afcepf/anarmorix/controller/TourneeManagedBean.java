package fr.afcepf.anarmorix.controller;




import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.LigneCommande;
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
     * Collection des commerces à visiter.
     */
    private List<CommerceVue> commercesAVisiter = new ArrayList<>();
    /**
     * Classe contenant les méthodes à appeler.
     */
    @EJB
    private IBusinessLivreur busLivreur;
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
        try {
            selectedTournee = busLivreur.setLignesCommandes(selectedTournee);
            List<Exploitation> collectionExploitation = busLivreur.setExploitationAVisiter(selectedTournee);
            for (Exploitation exploitation : collectionExploitation) {
                CommerceVue commerce = new CommerceVue();
                commerce.setCommerce(exploitation);
                for (LigneCommande ligne : selectedTournee.getLignesCmd()) {
                    if (ligne.getProduit().getCatalogues().get(0).getExploitation().getId() == exploitation.getId()) {
                        commerce.getListeLigneCmd().add(ligne);
                    }
                }
                commercesAVisiter.add(commerce);
            }
            for (CommerceVue commerceVue : commercesAVisiter) {
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
     * @return the commercesAVisiter
     */
    public List<CommerceVue> getCommercesAVisiter() {
        return commercesAVisiter;
    }
    /**
     * @param paramCommercesAVisiter the commercesAVisiter to set
     */
    public void setCommercesAVisiter(List<CommerceVue> paramCommercesAVisiter) {
        commercesAVisiter = paramCommercesAVisiter;
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
}
