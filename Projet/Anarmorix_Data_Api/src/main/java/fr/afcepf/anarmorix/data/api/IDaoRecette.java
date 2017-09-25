package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Recette;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoRecette {

    /**
     * @param libelle 
     * @return
     */
    public List<Recette> rechercher(String libelle) throws AnarmorixException;

    /**
     * @param recette 
     * @return
     */
    public Recette ajouter(Recette recette) throws AnarmorixException;

    /**
     * @param id
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Recette mettreAJour(Integer id) throws AnarmorixException;

}