package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.data.Api.IDaoAdherent;
import fr.afcepf.anarmorix.data.Api.IDaoCommande;
import fr.afcepf.anarmorix.data.Api.IDaoCommerce;
import fr.afcepf.anarmorix.data.Api.IDaoHoraire;
import fr.afcepf.anarmorix.data.Api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.Api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.Api.IDaoProduit;
import fr.afcepf.anarmorix.data.Api.IDaoVille;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.entity.Ville;

/**
 * 
 */
public class BusinessClient implements IBusinessClient {

    /**
     * Default constructor
     */
    public BusinessClient() {
    }

    /**
     * 
     */
    public IDaoHoraire daoHoraire;

    /**
     * 
     */
    public IDaoJourOuverture daoJourOverture;

    /**
     * 
     */
    private IDaoVille daoVille;

    /**
     * 
     */
    private IDaoCommerce daoCommerce;

    /**
     * 
     */
    private IDaoProduit daoProduit;

    /**
     * 
     */
    private IDaoLigneCommande daoLignecommande;

    /**
     * 
     */
    public IDaoCommande daoCommande;

    /**
     * 
     */
    public IDaoAdherent daoAdresse;

    /**
     * @param ville 
     * @return
     */
    public List<PointRelais> rechercherPointRelais(Ville ville) {
        // TODO implement here
        return null;
    }

    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    public LigneCommande ajouter(Produit produit, Double quantite) {
        // TODO implement here
        return null;
    }

    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    public LigneCommande retirer(Produit produit, Double quantite) {
        // TODO implement here
        return null;
    }

    /**
     * @param commande 
     * @return
     */
    public Boolean annulerCommande(Commande commande) {
        // TODO implement here
        return null;
    }

    /**
     * @param commande 
     * @return
     */
    public Commande valider(Commande commande) {
        // TODO implement here
        return null;
    }

    /**
     * @param prix 
     * @return
     */
    public Boolean payer(Double prix) {
        // TODO implement here
        return null;
    }

    /**
     * @param listeProduit 
     * @return
     */
    public List<LigneCommande> ajouterProduitRecette(List<Produit> listeProduit) {
        // TODO implement here
        return null;
    }

    /**
     * @param client 
     * @return
     */
    public Client sinscrire(Client client) {
        // TODO implement here
        return null;
    }

    /**
     * @param client 
     * @return
     */
    public Client modifierProfil(Client client) {
        // TODO implement here
        return null;
    }

}