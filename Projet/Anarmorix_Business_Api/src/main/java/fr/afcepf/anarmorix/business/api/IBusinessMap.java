package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Interface contenant les méthodes de la map.
 * @author Aubin
 *
 */
public interface IBusinessMap {
    /**
     * Méthode retournant tout les {@link PointRelais} de la base.
     * @return la liste des point-relais de la base.
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<PointRelais> getAllPointRelais() throws AnarmorixException;
    /**
     * Méthode alimentant un {@link PointRelais} avec son {@link Adresse} (avec ville et code postal), ses jours d'ouvertures et leurs horaires associés.
     * @param paramPointRelais le point relais à alimenter
     * @return le point relais avec son adresse et sa liste de jours d'ouverture
     @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     *  <li>Le point-relais n'existe pas en base de données.</li>
     * </ul>
     */
    PointRelais alimenterPointRelais(PointRelais paramPointRelais) throws AnarmorixException;
    /**
     * Méthode alimentant une {@link Adresse} avec sa {@link Ville} et son {@link CodePostal}.
     * @param paramAdresse l'adresse à alimenter
     * @return l'adresse sa ville et son code postal
     @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     *  <li>L'adresse n'existe pas en base de données.</li>
     * </ul>
     */
    Adresse alimenterAdresse(Adresse paramAdresse) throws AnarmorixException;
    /**
     * Méthode alimentant un {@link JourOuverture} avec sa liste de {@link Horaire}.
     * @param paramJourOuverture le jour ouverture à alimenter
     * @return le jour ouverture avec sa liste d'horaire
     @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     *  <li>Le jour d'ouverture n'est pas en base de données.</li>
     * </ul>
     */
    JourOuverture alimenterJourOuverture(JourOuverture paramJourOuverture) throws AnarmorixException;
}
