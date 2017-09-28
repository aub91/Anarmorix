package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * ManagedBean Livreur.
 * @author Aubin
 *
 */
@ViewScoped
@ManagedBean(name = "mbLivreur")
public class LivreurManagedBean {
    /**
     * Classe contenant les méthodes à appeler.
     */
    @EJB
    private IBusinessLivreur busLivreur;
    /**
     * ManagedBean de connexion.
     */
    @ManagedProperty(value = "#{mbConnexion}")
    private ConnexionCommandeManagedBean cnxMb;
    /**
     * Livreur connecté.
     */
    private Livreur livreur;
    /**
     * Liste des tournées.
     */
    private List<Tournee> listeTournee = new ArrayList<>();
    /**
     * Tournée sélectionnée.
     */
    private Tournee tourneeSelectionnee;
    /**
     * Méthode d'initialisation de la page tournee.xhtml.
     */
    @PostConstruct
    public void setDonnees() {
        System.out.println("coucou");
        livreur = (Livreur) cnxMb.getConnectedAdh();
        try {
            livreur = busLivreur.alimenterLivreur(livreur);
            livreur.setSociete(busLivreur.setTournees(livreur.getSociete()));
            for (Tournee tournee : livreur.getSociete().getTournees()) {
                tournee = busLivreur.setLignesCommandes(tournee);
                listeTournee.add(tournee);
            }
        } catch (AnarmorixException e) {
            e.printStackTrace();
        }
    }
    /**
     * Méthode déclenchant une tournée.
     * @param paramTournee la tournée à commencé
     * @return l'url de la tournée
     */
    public String commencerTournee(Tournee paramTournee) {
        for (Tournee tournee : listeTournee) {
            if (tournee.getId() == paramTournee.getId()) {
                tournee.setDateHeureDebut(new Date());
                tournee.setLivreur(livreur);
                try {
                    tourneeSelectionnee = busLivreur.mettreAJour(tournee);
                } catch (AnarmorixException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "/tourneeMobile.jsf?id=" + paramTournee.getId() + "&faces-redirect=true";
    }
    /**
     * Méthode pour déterminer le statut d'une tournée.
     * @param paramTournee tournée dont le statut est à déterminer.
     * @return le statut de la tournee
     */
    public String determinerStatut(Tournee paramTournee) {
        if (paramTournee.getDateHeureDebut() == null) {
            return "Non commencée";
        } else {
            if (paramTournee.getDateHeureFin() == null) {
                return "En cours";
            } else {
                return "Terminée";
            }
        }
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
    /**
     * @return the tourneeSelectionnee
     */
    public Tournee getTourneeSelectionnee() {
        return tourneeSelectionnee;
    }
    /**
     * @param paramTourneeSelectionnee the tourneeSelectionnee to set
     */
    public void setTourneeSelectionnee(Tournee paramTourneeSelectionnee) {
        tourneeSelectionnee = paramTourneeSelectionnee;
    }
    /**
     * @return the listeTournee
     */
    public List<Tournee> getListeTournee() {
        return listeTournee;
    }
    /**
     * @param paramListeTournee the listeTournee to set
     */
    public void setListeTournee(List<Tournee> paramListeTournee) {
        listeTournee = paramListeTournee;
    }
    
}
