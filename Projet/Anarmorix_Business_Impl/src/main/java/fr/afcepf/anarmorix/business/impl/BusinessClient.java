package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoVille;
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
@Remote(IBusinessClient.class)
@Stateless
public class BusinessClient implements IBusinessClient {

    /**
     * Default constructor
     */
    private BusinessClient() {
    }

    /**
     * Interface d'accès aux données {@link Horaire}
     */
    private IDaoHoraire daoHoraire;

    /**
     * Interface d'accès aux données {@link JourOuverture}
     */
    public IDaoJourOuverture daoJourOverture;

    /**
     * Interface d'accès aux données {@link Ville}
     */
    private IDaoVille daoVille;

    /**
     * Interface d'accès aux données {@link Commerce}
     */
    private IDaoCommerce daoCommerce;

    /**
     * Interface d'accès aux données {@link Produit}
     */
    private IDaoProduit daoProduit;

    /**
     * Interface d'accès aux données {@link LigneCommande}
     */
    private IDaoLigneCommande daoLignecommande;

    /**
     * Interface d'accès aux données {@link Commande}
     */
    public IDaoCommande daoCommande;

    /**
     * Interface d'accès aux données {@link Adresse}
     */
    public IDaoAdherent daoAdresse;

    /**
     * Méthode permettant de de trouver la liste des {@link PointRelais} d'une {@link Ville}.
     * @param ville 
     * @return List<PointRelais>, la liste des poitns relais d'une ville.
     */
    public List<PointRelais> rechercherPointRelais(Ville ville) {
        // TODO implement here
        return null;
    }

    /**
     * Méthode permettant de créer une ligne de commande.
     * @param produit 
     * @param quantite 
     * @return
     */
/*Note : Modifiée.*/
    public Commande ajouterLigneCommande(Commande commande) throws AnarmorixException {
        commande.setLignesCommande(daoLignecommande.rechercher(commande));
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
        return client;
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