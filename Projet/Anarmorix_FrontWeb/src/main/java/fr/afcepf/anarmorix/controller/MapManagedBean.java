package fr.afcepf.anarmorix.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import fr.afcepf.anarmorix.business.api.IBusinessMap;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;

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
     * Classe contenant la méthode à appeler.
     */
    @EJB
    private IBusinessMap busMap;
    /**
     * Message JSon permettant d'afficher les point-relais sur la map.
     */
    private StringBuilder jSonPointRelais = new StringBuilder("{'marker': [");
    /**
     * Valeur du champ recherche.
     */
    private String centre;
    /**
     * Latitude du centre de la crate.
     */
    private String lat = "47.577512";
    /**
     * Longitude du centre de la carte.
     */
    private String longi = "2.387635";
    /**
     * Niveau de zoom de la carte.
     */
    private String zoom = "6";
    /**
     * Api Key pour googleMap API.
     */
    private String apiKey = "AIzaSyCf-7j3fGn9ixB1w2exeFysSJtWlWUYiFc";
    /**
     * Méthode recherchant les point-relais de la base.
     */
    @PostConstruct
    public void rechercherPointRelais() {
        try {
            liste = busMap.getAllPointRelais();
            for (PointRelais pr : liste) {
                StringBuilder sbAdress = new StringBuilder();
                sbAdress.append(pr.getAdresse().getNumero()).append(" ").append(pr.getAdresse().getVoie()).append(", ")
                .append(pr.getAdresse().getCodePostal().getCodePostal()).append(" ").append(pr.getAdresse().getVille().getNomVille())
                .append(", France', 'lat': '").append(pr.getAdresse().getLatitude()).append("', 'lng': '").append(pr.getAdresse().getLongitude());

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
                if (pr.getJoursOuverture().size() != 0) {
                sbJourOuverture.delete(sbJourOuverture.length() - 2, sbJourOuverture.length());
                }
                sbJourOuverture.append("]}, ");
                jSonPointRelais.append("{'name': '").append(pr.getRaisonSociale()).append("', 'id': '").append(pr.getId())
                .append("', 'address': '").append(sbAdress).append("', ").append(sbJourOuverture);
            }
            jSonPointRelais.delete(jSonPointRelais.length() - 2, jSonPointRelais.length()).append("]}");
        } catch (AnarmorixException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * Méthode pour rechercher un point particulier.
     */
    public void rechercherPoint() {
        if (centre != null && centre != "") {
            GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();
                GeocodingResult[] results;
                try {
                    results = GeocodingApi.geocode(context, centre).region("fr").await();
                    lat = String.valueOf(results[0].geometry.location.lat);
                    longi = String.valueOf(results[0].geometry.location.lng);
                    zoom = "14";
                } catch (ApiException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
    public StringBuilder getjSonPointRelais() {
        return jSonPointRelais;
    }
    /**
     * @param paramJSonPointRelais the jSonPointRelais to set
     */
    public void setjSonPointRelais(StringBuilder paramJSonPointRelais) {
        jSonPointRelais = paramJSonPointRelais;
    }

    /**
     * @return the centre
     */
    public String getCentre() {
        return centre;
    }

    /**
     * @param paramCentre the centre to set
     */
    public void setCentre(String paramCentre) {
        centre = paramCentre;
    }

    /**
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param paramLat the lat to set
     */
    public void setLat(String paramLat) {
        lat = paramLat;
    }

    /**
     * @return the longi
     */
    public String getLongi() {
        return longi;
    }

    /**
     * @param paramLongi the longi to set
     */
    public void setLongi(String paramLongi) {
        longi = paramLongi;
    }

    /**
     * @return the zoom
     */
    public String getZoom() {
        return zoom;
    }

    /**
     * @param paramZoom the zoom to set
     */
    public void setZoom(String paramZoom) {
        zoom = paramZoom;
    }

}
