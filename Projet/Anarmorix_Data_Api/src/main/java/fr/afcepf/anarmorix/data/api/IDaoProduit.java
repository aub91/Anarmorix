package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface produit.
 */
public interface IDaoProduit {

    /**
     * methode qui retroune une liste de produit par ID.
     * @param id ID to Set id produit.
     * @return une liste de produit.
     * @throws AnarmorixException
     *<ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<Produit> rechercherParID(Integer id) throws AnarmorixException;

    /**
     * methode qui retourne une liste de produit par IDtypeProduit.
     * @param id ID to Set id produit.
     * @return une liste de produit.
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<Produit> rechercherParIDTypeProduit(Integer id) throws AnarmorixException;

    /**
     * Méthode qui retourne la liste de tous les produits.
     * @return une liste de produit.
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    List<Produit> rechercherTousLesProduits() throws AnarmorixException;

    /**
     * @param produit 
     * @return
     */
    public Produit ajouter(Produit produit) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Produit mettreAJour(Integer id) throws AnarmorixException;

}