package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link PointRelais} dans le système.
 * @author Aubin
 *
 */
public interface IDaoPointRelais {
    /**
     * Méthode permettant de trouver les {@link PointRelais}.
     * @return la liste de {@link PointRelais} enregistrés dans le système
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<PointRelais> getAll() throws AnarmorixException;

}
