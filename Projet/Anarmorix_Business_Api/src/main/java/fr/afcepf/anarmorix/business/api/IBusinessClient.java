package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier du client.
 */
public interface IBusinessClient {

    /**
     * @param ville ville de recherche
     * @return liste de point-relais de la ville
     * @throws AnarmorixException une exception
     */
    List<PointRelais> rechercherPointRelais(Ville ville) throws AnarmorixException;

    /**
     * Méthode permettant d'ajouter une liste de lignes de commandes à une commande.
     * @param paramCommande une commande avec ses lignes à faire persister
     * @return la commande avec ses listes de lignes
     * @throws AnarmorixException une exception
     */
    Commande ajouterListeLigneCommande(Commande paramCommande) throws AnarmorixException;

    /**
     * Méthode de vérification de catégorie fille.
     * @param paramCategorie catégorie à examiner
     * @return true si pas de catégories filles
     */
    boolean isCategorieFille(Categorie paramCategorie);
    /**
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    List<Produit> recupererTousLesProduits() throws AnarmorixException;
    /**
     * @param idTypeProduit id du type produit
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    List<Produit> recupererLesProduitsParType(Integer idTypeProduit) throws AnarmorixException;
    /**
     * Methode pour récupérer  les produits par libelle de categorie.
     * @param libelleCategorie le nom de la catégorie
     * @param reset un booléen
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    List<Produit> recupererLesProduitsParCategorie(String libelleCategorie, boolean reset) throws AnarmorixException;
    /**
     * @return une liste de categorie.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererToutesLesCategories() throws AnarmorixException;
    
}