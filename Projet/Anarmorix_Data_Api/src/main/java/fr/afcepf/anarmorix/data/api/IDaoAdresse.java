package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link Adresse} dans le système.
 */
public interface IDaoAdresse {

    /**
     * @param numero
     * @param voie
     * @return
     */
    List<Adresse> rechercher(Ville ville) throws AnarmorixException;

    /**
     * @param adresse
     * @return
     */
    Adresse ajouter(Adresse adresse) throws AnarmorixException;

    /**
     * @param id
     * @return
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id
     * @return
     */
    Adresse mettreAJour(Integer id) throws AnarmorixException;
    /**
     * @param paramCommerce le commerce dont on cherche l'adresse
     * @return le commerce avec son adresse
     * @throws AnarmorixException exception
     */
    Commerce getByCommerce(Commerce paramCommerce) throws AnarmorixException;

}