package fr.afcepf.anarmorix.data.Api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Recette;

/**
 * 
 */
public interface IDaoRecette {

    /**
     * @param libelle 
     * @return
     */
    public List<Recette> rechercher(String libelle);

    /**
     * @param recette 
     * @return
     */
    public Recette ajouter(Recette recette);

    /**
     * @param id
     */
    public void supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Recette mettreAJour(Integer id);

}