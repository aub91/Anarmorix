package fr.afcepf.anarmorix.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

    /**
     * Méthode recherchant les point-relais de la base.
     */
    @PostConstruct
    public void rechercherPointRelais() {
        CodePostal cp1 = new CodePostal(null, "75012");
        Ville ville1 = new Ville(null, "Paris");
        CodePostal cp2 = new CodePostal(null, "75014");
        Adresse adresse1 = new Adresse(null, 1, null, "route de Pesage", cp1, ville1, "2.444399", "48.822477");
        Adresse adresse2 = new Adresse(null, 1, null, "Boulevard Brune", cp2, ville1, "2.323553", "48.823423");
        PointRelais pr1 = new PointRelais(null, null, null, null, null, "Ferme de Paris", adresse1, null);
        PointRelais pr2 = new PointRelais(null, null, null, null, null, "Supérette d Orléans", adresse2, null);

        JourOuverture jour1 = new JourOuverture(null, "Lundi", null);
        JourOuverture jour2 = new JourOuverture(null, "Mardi", null);
        Horaire horaire1 = new Horaire(null, "matin", "9h00", "12h00", jour1);
        Horaire horaire2 = new Horaire(null, "après-midi", "13h00", "19h00", jour1);
        Horaire horaire3 = new Horaire(null, "journée", "9h00", "21h00", jour2);
        List<Horaire> horaires = new ArrayList<>();
        List<Horaire> horaires2 = new ArrayList<>();
        horaires.add(horaire1);
        horaires.add(horaire2);
        jour1.setHorairesOuverture(horaires);
        horaires2.add(horaire3);
        jour2.setHorairesOuverture(horaires);
        List<JourOuverture> jourOuvertures = new ArrayList<>();
        List<JourOuverture> jourOuvertures2 = new ArrayList<>();
        jourOuvertures.add(jour1);
        jourOuvertures2.add(jour2);
        pr1.setJoursOuverture(jourOuvertures);
        pr2.setJoursOuverture(jourOuvertures2);
        liste.add(pr1);
        liste.add(pr2);

        for (PointRelais pr : liste) {

            StringBuilder sbAdress = new StringBuilder();
            sbAdress.append(pr.getAdresse().getNumero()).append(" ").append(pr.getAdresse().getVoie()).append(", ")
            .append(pr.getAdresse().getCodePostal().getCodePostal()).append(" ").append(pr.getAdresse().getVille().getNomVille()).append(", France', 'lat': '")
            .append(pr.getAdresse().getLatitude()).append("', 'lng': '").append(pr.getAdresse().getLongitude());

            StringBuilder sbJourOuverture = new StringBuilder("'jourOuverture': [");
            for (JourOuverture jourOuverture : pr.getJoursOuverture()) {
                StringBuilder sbJour = new StringBuilder("{'jour': '");
                sbJour.append(jourOuverture.getLibelle()).append("', 'horaire': [");
                for (Horaire horaire : jourOuverture.getHorairesOuverture()) {
                    StringBuilder sbHoraire = new StringBuilder("{'periode': '");
                    sbHoraire.append(horaire.getLibelle()).append("', 'ouverture': '").append(horaire.getHeureOuverture())
                    .append("', 'fermeture': '").append(horaire.getHeureFermeture()).append("'}, ");
                    sbJour.append(sbHoraire);
                }
                sbJour.delete(sbJour.length() - 2, sbJour.length()).append("]}, ");
                sbJourOuverture.append(sbJour);
            }
            sbJourOuverture.delete(sbJourOuverture.length() - 2, sbJourOuverture.length()).append("]}, ");
            jSonPointRelais.append("{'name': '").append(pr.getRaisonSociale()).append("', 'address': '").append(sbAdress).append("', ").append(sbJourOuverture);
        }
        jSonPointRelais.delete(jSonPointRelais.length() - 2, jSonPointRelais.length()).append("]}");
        System.out.println(jSonPointRelais);
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
    public StringBuilder getjSonPointRelais() {
        return jSonPointRelais;
    }
    /**
     * @param paramJSonPointRelais the jSonPointRelais to set
     */
    public void setjSonPointRelais(StringBuilder paramJSonPointRelais) {
        jSonPointRelais = paramJSonPointRelais;
    }

}
