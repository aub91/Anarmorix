package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Ville;

/**
 * 
 */
public interface IBusinessClient {

    /**
     * @param ville 
     * @return
     */
    public List<PointRelais> rechercherPointRelais(Ville ville);

    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    public LigneCommande ajouter(Produit produit, Double quantite);

    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    public LigneCommande retirer(Produit produit, Double quantite);

    /**
     * @param commande 
     * @return
     */
    public Boolean annulerCommande(Commande commande);

    /**
     * @param commande 
     * @return
     */
    public Commande valider(Commande commande);

    /**
     * @param prix 
     * @return
     */
    public Boolean payer(Double prix);

    /**
     * @param listeProduit 
     * @return
     */
    public List<LigneCommande> ajouterProduitRecette(List<Produit> listeProduit);

    /**
     * @param client 
     * @return
     */
    public Client sinscrire(Client client);

    /**
     * @param client 
     * @return
     */
    public Client modifierProfil(Client client);

}