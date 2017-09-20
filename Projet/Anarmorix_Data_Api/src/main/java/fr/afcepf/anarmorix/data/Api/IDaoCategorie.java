package fr.afcepf.anarmorix.data.Api;

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
    public List<Categorie> rechercher(String nom);

    /**
     * @return
     */
    public Categorie ajouter();

    /**
     * @param categorie
     */
    public void supprimer(Categorie categorie);

    /**
     * @param categorie 
     * @return
     */
    public Categorie mettreAJour(Categorie categorie);

}