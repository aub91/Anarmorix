package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Ville;

/**
 * Classe contenant les fonctionnalités de la carte.
 * @author Aubin
 *
 */
@SessionScoped
@ManagedBean(name = "mbMap")
public class MapManagedBean {
    /**
     * Liste des point-relais de la base.
     */
    private List<PointRelais> liste = new ArrayList<>();
    /**
     * Message JSon permettant d'afficher les point-relais sur la map.
     */
    private StringBuilder jSonPointRelais = new StringBuilder("{'marker': [");
    //{"name": "Supérette d'Orléans", "address": "130 Boulevard Brune, 75014 Paris, France", "lat": "48.823423", "lng": "2.323553", "type": "pointRelais"},
    /**
     * Méthode recherchant les point-relais de la base.
     */
    public void rechercherPointRelais() {
        CodePostal cp1 = new CodePostal(null, "75012");
        Ville ville1 = new Ville(null, "Paris");
        CodePostal cp2 = new CodePostal(null, "75014");
        Adresse adresse1 = new Adresse(null, 1, null, "route de Pesage", cp1, ville1, "48.822477", "2.444399");
        Adresse adresse2 = new Adresse(null, 1, null, "Boulevard Brune", cp2, ville1, "48.823423", "2.323553");
        PointRelais pr1 = new PointRelais(null, null, null, null, null, "Ferme de Paris", adresse1, null);
        PointRelais pr2 = new PointRelais(null, null, null, null, null, "Supérette d'Orléans", adresse2, null);

        JourOuverture jour1 = new JourOuverture(null, "Lundi", null);
        JourOuverture jour2 = new JourOuverture(null, "Mardi", null);
        Horaire horaire1 = new Horaire(null, "matin", "9:00", "12:00", jour1);
        Horaire horaire2 = new Horaire(null, "après-midi", "13:00", "19:00", jour1);
        Horaire horaire3 = new Horaire(null, "journée", "9:00", "21:00", jour2);
        jour1.getHorairesOuverture().add(horaire1);
        jour1.getHorairesOuverture().add(horaire2);
        jour2.getHorairesOuverture().add(horaire3);
        pr1.getJoursOuverture().add(jour1);
        pr2.getJoursOuverture().add(jour2);
        liste.add(pr1);
        liste.add(pr2);

        for (PointRelais pr : liste) {

            StringBuilder sbAdress = new StringBuilder();
            sbAdress.append(pr.getAdresse().getNumero()).append(" ").append(pr.getAdresse().getVoie()).append(", ")
            .append(pr.getAdresse().getCodePostal()).append(" ").append(pr.getAdresse().getVille()).append(", France', 'lat': '")
            .append(pr.getAdresse().getLatitude()).append("', 'lng': '").append(pr.getAdresse().getLongitude());

            StringBuilder sbJourOuverture = new StringBuilder("'jourOuverture': [");
            for (JourOuverture jourOuverture : pr.getJoursOuverture()) {
                StringBuilder sbJour = new StringBuilder("{'jour': '");
                sbJour.append(jourOuverture.getLibelle()).append("', 'horaire': [");
                for (Horaire horaire : jourOuverture.getHorairesOuverture()) {
                    
                }
            }
            jSonPointRelais.append("{'name': '").append(pr.getRaisonSociale()).append("', 'address': '").append(sbAdress).append("', ");
        }
    }
    /**
     * @return the liste
     */
    public List<PointRelais> getListe() {
        return liste;
    }
    /**
     * @param paramListe the liste to set
     */
    public void setListe(List<PointRelais> paramListe) {
        liste = paramListe;
    }
    /**
     * @return the jSonPointRelais
     */
    public String getjSonPointRelais() {
        return jSonPointRelais;
    }
    /**
     * @param paramJSonPointRelais the jSonPointRelais to set
     */
    public void setjSonPointRelais(String paramJSonPointRelais) {
        jSonPointRelais = paramJSonPointRelais;
    }

}
