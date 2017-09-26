package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.LigneCommande;
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
     * Méthode qui cherche le {@link Produit} associé à une {@link LigneCommande}.
     * @param paramLigneCommande une {@link LigneCommande} sans son produit.
     * @return une {@link LigneCommande} avec son produit associé.
     * @throws AnarmorixException
     * <ul>
     *  <li>Le serveur de données ne répond pas</li>
     * </ul>
     */
    LigneCommande rechercherByLigneCommande(LigneCommande paramLigneCommande) throws AnarmorixException;

}