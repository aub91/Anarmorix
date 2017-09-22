package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link JourOuverture} dans le système.
 * @author Aubin
 *
 */
public interface IDaoJourOuverture {
    /**
     * Méthode de recherche des jours d'ouverture d'un point-relais.
     * @param paramPointRelais le {@link PointRelais} dont on recherche le {@link JourOuverture}
     * @return le point-relais avec sa liste des {@link JourOuverture}
     * @throws AnarmorixException une exception
     */
    PointRelais getAllByPointRelais(PointRelais paramPointRelais) throws AnarmorixException;

}
