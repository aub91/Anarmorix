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
<<<<<<< HEAD
    public List<Adresse> rechercher(Ville ville) throws AnarmorixException;
=======
   List<Ville> rechercher(Integer numero, String voie) throws Exception;
>>>>>>> aubin

    /**
     * @param adresse
     * @return
     */
<<<<<<< HEAD
    public Adresse ajouter(Adresse adresse) throws AnarmorixException;
=======
    Adresse ajouter(Adresse adresse) throws Exception;
>>>>>>> aubin

    /**
     * @param id
     * @return
     */
<<<<<<< HEAD
    public Boolean supprimer(Integer id) throws AnarmorixException;
=======
    Boolean supprimer(Integer id) throws Exception;
>>>>>>> aubin

    /**
     * @param id
     * @return
     */
<<<<<<< HEAD
    public Adresse mettreAJour(Integer id) throws AnarmorixException;
=======
    Adresse mettreAJour(Integer id) throws Exception;
    /**
     * @param paramCommerce le commerce dont on cherche l'adresse
     * @return le commerce avec son adresse
     * @throws AnarmorixException exception
     */
    Commerce getByCommerce(Commerce paramCommerce) throws AnarmorixException;
>>>>>>> aubin

}