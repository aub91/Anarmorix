package fr.afcepf.anarmorix.controller;




import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.entity.Commerce;

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
    private Set<Commerce> commercesAVisiter = new LinkedHashSet<>();
    /**
     * Classe contenant les méthodes à appeler.
     */
    @EJB
    private IBusinessLivreur busLivreur;
}
