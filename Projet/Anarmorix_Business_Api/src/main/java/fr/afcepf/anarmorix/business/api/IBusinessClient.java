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
 * 
 */
public interface IBusinessClient {

    /**
     * @param ville 
     * @return
     */
    List<PointRelais> rechercherPointRelais(Ville ville);
    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    Commande ajouterLigneCommande(Commande commande) throws AnarmorixException;
    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    LigneCommande retirer(Produit produit, Double quantite);
    /**
     * @param commande 
     * @return
     */
    Boolean annulerCommande(Commande commande);
    /**
     * @param commande 
     * @return
     */
    Commande valider(Commande commande);
    /**
     * @param prix 
     * @return
     */
    Boolean payer(Double prix);

    /**
     * @param listeProduit 
     * @return
     */
    List<LigneCommande> ajouterProduitRecette(List<Produit> listeProduit);

    /**
     * @param client 
     * @return
     */
    Client sinscrire(Client client);

    /**
     * @param client 
     * @return
     */
    Client modifierProfil(Client client);
    
    /**
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    List<Produit> choisirCategorieProduit() throws AnarmorixException;
    /**
     * @return une liste de categorie.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererToutesLesCategories() throws AnarmorixException;
    /**
     * @return une liste de categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererCategoriesPrimaires() throws AnarmorixException;
    /**
     * @return une liste de categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererCategoriesSecondaires() throws AnarmorixException;
    /**
     * @return une liste de categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererCategoriesTertiaires() throws AnarmorixException;
    /**
     * @param idCatgorieMere l'id de la catégorie mère.
     * @return une liste de categories.
     * @throws AnarmorixException exception serveur.
     */
    List<Categorie> recupererCategoriesFilles(Integer idCatgorieMere) throws AnarmorixException;
}