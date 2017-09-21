package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Categorie;

/**
 * 
 */
public interface IDaoCategorie {

    /**
     * @param nom 
     * @return
     */
    public List<Categorie> rechercher(String nom) throws Exception;

    /**
     * @return
     */
    public Categorie ajouter() throws Exception;

    /**
     * @param categorie
     */
    public void supprimer(Categorie categorie) throws Exception;

    /**
     * @param categorie 
     * @return
     */
    public Categorie mettreAJour(Categorie categorie) throws Exception;

}