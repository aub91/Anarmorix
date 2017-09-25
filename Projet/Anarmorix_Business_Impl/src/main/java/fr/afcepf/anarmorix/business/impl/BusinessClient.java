package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import javax.ejb.EJB;
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
import fr.afcepf.anarmorix.entity.Statut;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;


/**
 * Implémentation des méthodes clients de la couche business.
 */
@Remote(IBusinessClient.class)
@Stateless
public class BusinessClient implements IBusinessClient {
    /**
     * Default constructor
     */
    public BusinessClient() {
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
     * Interface d'accès aux données {@link Ville}.
     */
    private IDaoVille daoVille;

    /**
     * Interface d'accès aux données {@link Commerce}.
     */
    private IDaoCommerce daoCommerce;

    /**
     * Interface d'accès aux données {@link Produit}.
     */
    @EJB
    private IDaoProduit daoProduit;
    /**
     * Interface d'accès aux données {@link LigneCommande}.
     */
    private IDaoLigneCommande daoLignecommande;

    /**
     * Interface d'accès aux données {@link Commande}.
     */
    private IDaoCommande daoCommande;

    /**
     * Interface d'accès aux données {@link Adresse}.
     */
    private IDaoAdherent daoAdresse;

    /**
     * Méthode permettant de de trouver la liste des {@link PointRelais} d'une {@link Ville}.
     * @param ville 
     * @return List<PointRelais>, la liste des poitns relais d'une ville.
     */
    public List<PointRelais> rechercherPointRelais(Ville ville) throws AnarmorixException {
        return daoCommerce.rechercherPointsRelais(ville);
    }

    /**
     * Méthode permettant de créer une ligne de commande.
     * @param produit 
     * @param quantite 
     * @return
     */
    public Commande ajouterLigneCommande(Commande commande) throws AnarmorixException {
        commande.setLignesCommande(daoLignecommande.rechercher(commande));
        return commande;
    }

    /**
     * @param produit 
     * @param quantite 
     * @return
     */
    public LigneCommande retirer(Produit produit, Double quantite) throws AnarmorixException  {
        // TODO implement here
        return null;
    }

    /**
     * @param commande 
     * @return true si la commande est annulée.
     * @throws AnarmorixException COMMANDE NON ANNULABLE si la préparation a commencé.
     * @throws AnarmorixException ERREUR NON IDENTIFIEE dans les autres cas d'erreur.
     */
    public Boolean annulerCommande(Commande commande) throws AnarmorixException {
        try {
            if (commande.getStatut() == Statut.CREEE || commande.getStatut() == Statut.EN_ATTENTE_DE_PREPARATION) {
                daoCommande.supprimer(commande.getId());
                return true;
            } else {
                AnarmorixException exc =
                new AnarmorixException("La commande ne peut plus être annulée", AnarmorixExceptionEnum.COMMANDE_NON_ANNULABLE);
                throw exc;
            }
        } catch (Exception e) {
            if (e.getMessage() == "La commande ne peut plus être annulée") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
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

    @Override
    public List<Produit> choisirCategorieProduit() throws AnarmorixException {
        List<Produit> produits = null;
        try {
            produits = daoProduit.rechercherTousLesProduits();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return produits;
    }
}