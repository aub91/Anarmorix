package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link Horaire} dans le système.
 */
public interface IDaoHoraire {

    /**
     * @param horaire 
     * @return
     */
    Horaire ajouter(Horaire horaire) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    Horaire mettreAJour(Integer id) throws AnarmorixException;
    /**
     * @param paramJourOuverture {@link JourOuverture} dont on cherche les horaires
     * @return {@link JourOuverture} avec sa liste d'horaire.
     * @throws AnarmorixException une exception
     */
    JourOuverture getHoraireByJourOuverture(JourOuverture paramJourOuverture) throws AnarmorixException;

}