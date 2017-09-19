package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Ville;

/**
 * 
 */
public interface IDaoVille {

    /**
     * @param nom 
     * @return
     */
    public List<Ville> rechercher(String nom);

    /**
     * @param ville 
     * @return
     */
    public Ville ajouter(Ville ville);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Ville mettreAJour(Integer id);

}