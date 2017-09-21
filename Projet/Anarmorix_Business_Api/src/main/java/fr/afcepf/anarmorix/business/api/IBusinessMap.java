package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Interface contenant les méthodes de la map.
 * @author Aubin
 *
 */
public interface IBusinessMap {
    /**
     * Méthode retournant tout les point-relais de la base.
     * @return la liste des point-relais de la base.
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<PointRelais> getAllPointRelais() throws AnarmorixException;
}
