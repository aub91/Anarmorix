package fr.afcepf.anarmorix.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoVille;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.JourOuverture;
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
     * Default constructor.
     */
    public BusinessClient() {
    }

    /**
     * Interface d'accès aux données {@link Horaire}.
     */
    private IDaoHoraire daoHoraire;

    /**
     * Interface d'accès aux données {@link JourOuverture}.
     */
    private IDaoJourOuverture daoJourOverture;

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
    @EJB
    private IDaoCategorie daoCategorie;
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
    /**
     * Methode pour récupérer tous les produits.
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Produit> recupererTousLesProduits() throws AnarmorixException {
        List<Produit> produits = null;
        try {
            produits = daoProduit.rechercherTousLesProduits();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return produits;
    }
    /**
     * Methode pour récupérer  les produits par type.
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Produit> recupererLesProduitsParType(Integer idTypeProduit) throws AnarmorixException {      
		List<Produit> produits = null;
		try {
			produits = daoProduit.rechercherParIDTypeProduit(idTypeProduit);
		} catch (Exception e) {
			AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
			throw exc;
		}
		return produits;
    }
    /**
     * Methode pour récupérer  les produits par type.
     * @return une liste de produits.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Produit> recupererLesProduitsParCategorie(String libelleCategorie) throws AnarmorixException {      
		List<Produit> produits = null;
		try {
			produits = daoProduit.rechercherParCategorie(libelleCategorie);
		} catch (Exception e) {
			AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
			throw exc;
		}
		return produits;
    }

    /**
     * Methode pour récupérer toutes les catégories.
     * @return une liste de catgégorie.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Categorie> recupererToutesLesCategories() throws AnarmorixException {
        List<Categorie> categories = null;
        try {
            categories = daoCategorie.rechercherTous();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return categories;
    }
    /**
     * Methode pour récupérer les catégories primaires.
     * @return une liste de catgégorie.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Categorie> recupererCategoriesPrimaires() throws AnarmorixException {
        List<Categorie> categories = recupererToutesLesCategories();
        List<Categorie> categoriesPrimaires = new ArrayList<>();
        for (Categorie categorie : categories) {
            if (categorie.getCategorieMere() == null) {
                categoriesPrimaires.add(categorie);
            }
        }
        return categoriesPrimaires;
    }
    /**
     * Methode pour récupérer toutes les catégories secondaires.
     * @return une liste de catgégorie.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Categorie> recupererCategoriesSecondaires() throws AnarmorixException {
        List<Categorie> categories = recupererToutesLesCategories();
        List<Categorie> categoriesSecondaires = new ArrayList<>();
        for (Categorie categorie : categories) {
            int nbParents = 0;
            Categorie categorieTemp = categorie.getCategorieMere();
            while (categorieTemp != null) {
                categorieTemp = categorieTemp.getCategorieMere();
                nbParents++;
            }
            if (nbParents == 1) {
                categoriesSecondaires.add(categorie);
            }
        }
        return categoriesSecondaires;
    }
    /**
     * Methode pour récupérer toutes les catégories tertiaires.
     * @return une liste de catgégorie.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Categorie> recupererCategoriesTertiaires() throws AnarmorixException {
        List<Categorie> categories = recupererToutesLesCategories();
        List<Categorie> categoriesTertiaires = new ArrayList<>();
        for (Categorie categorie : categories) {
            int nbParents = 0;
            Categorie categorieTemp = categorie.getCategorieMere();
            while (categorieTemp != null) {
                categorieTemp = categorieTemp.getCategorieMere();
                nbParents++;
            }
            if (nbParents == 2) {
                categoriesTertiaires.add(categorie);
            }
        }
        return categoriesTertiaires;
    }
    /**
     * Methode pour récupérer toutes les catégories t.
     * @return une liste de catgégorie.
     * @throws AnarmorixException exception serveur.
     */
    @Override
    public List<Categorie> recupererCategoriesFilles(Integer idCatgorieMere) throws AnarmorixException {
        List<Categorie> categories = recupererToutesLesCategories();
        List<Categorie> categoriesFilles = new ArrayList<>();
        for (Categorie categorie : categories) {
            if (categorie.getCategorieMere() != null) {
                if (categorie.getCategorieMere().getId() == idCatgorieMere) {
                    categoriesFilles.add(categorie);
                }
            }
        }
        return categoriesFilles;
    }
}