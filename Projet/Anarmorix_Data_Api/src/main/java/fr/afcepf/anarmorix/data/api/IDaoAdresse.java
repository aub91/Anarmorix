package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoAdresse {

    /**
     * @param numero 
     * @param voie 
     * @return
     */
    public List<Adresse> rechercher(Ville ville) throws AnarmorixException;

    /**
     * @param adresse 
     * @return
     */
    public Adresse ajouter(Adresse adresse) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Adresse mettreAJour(Integer id) throws AnarmorixException;

}