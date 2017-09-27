package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoCategorie {

    /**
     * recupere toutes les catéogories.
     * @return une liste categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> rechercherTous() throws AnarmorixException;
    /**
     * recupere les categorie par id.
     * @param idCategorie l'id dune categorie.
     * @return une liste categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> rechercherParId(Integer idCategorie) throws AnarmorixException;
    
    /**
     * recupere les categorie par libelle.
     * @param libelleCategorie le libelle dune categorie.
     * @return une liste categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> rechercherCategorieParLibelle (String libelleCategorie) throws AnarmorixException;
    
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