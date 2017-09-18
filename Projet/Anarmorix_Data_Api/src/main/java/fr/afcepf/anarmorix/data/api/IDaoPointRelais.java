package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.PointRelais;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link PointRelais} dans le système.
 * @author Aubin
 *
 */
public interface IDaoPointRelais {
    /**
     * Méthode permettant de trouver tous les points-relais du système.
     * @return la liste de {@link PointRelais} enregistrés dans le système
     */
    List<PointRelais> getAll();

}
