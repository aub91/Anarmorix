package fr.afcepf.anarmorix.business.api;

import java.util.List;

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
    List<PointRelais> rechercherPointRelais(Ville ville) throws AnarmorixException ;
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
    LigneCommande retirer(Produit produit, Double quantite) throws AnarmorixException ;
    /**
     * @param commande 
     * @return
     */
    Boolean annulerCommande(Commande commande) throws AnarmorixException ;
    /**
     * @param commande 
     * @return
     */
    Commande valider(Commande commande) throws AnarmorixException ;
    /**
     * @param prix 
     * @return
     */
    Boolean payer(Double prix) throws AnarmorixException ;

    /**
     * @param listeProduit 
     * @return
     */
    List<LigneCommande> ajouterProduitRecette(List<Produit> listeProduit) throws AnarmorixException ;

    /**
     * @param client 
     * @return
     */
    Client sinscrire(Client client) throws AnarmorixException ;

    /**
     * @param client 
     * @return
     */
    Client modifierProfil(Client client) throws AnarmorixException ;
    
    /**
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    List<Produit> choisirCategorieProduit() throws AnarmorixException;

}