package fr.afcepf.anarmorix.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;

import fr.afcepf.anarmorix.business.api.IBusinessClient;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommerce;
import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.data.api.IDaoJourOuverture;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.data.api.IDaoTypeProduit;
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
import fr.afcepf.anarmorix.entity.TypeProduit;
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
    @EJB
    private IDaoHoraire daoHoraire;

    /**
     * Interface d'accès aux données {@link JourOuverture}.
     */
    @EJB
    private IDaoJourOuverture daoJourOverture;

    /**
     * Interface d'accès aux données {@link Ville}.
     */
    @EJB
    private IDaoVille daoVille;

    /**
     * Interface d'accès aux données {@link Commerce}.
     */
    @EJB
    private IDaoCommerce daoCommerce;

    /**
     * Interface d'accès aux données {@link Produit}.
     */
    @EJB
    private IDaoProduit daoProduit;
    /**
     * Interface d'accès aux données {@link LigneCommandeCategorie}.
     */
    @EJB
    private IDaoCategorie daoCategorie;
    /**
     * Interface d'accès aux données {@link TypeProduit}.
     */
    @EJB
    private IDaoTypeProduit daoTypeProduit;
    /**
     * Interface d'accès aux données {@link LigneCommande}.
     */
    @EJB
    private IDaoLigneCommande daoLignecommande;

    /**
     * Interface d'accès aux données {@link Commande}.
     */
    @EJB
    private IDaoCommande daoCommande;

    /**
     * Interface d'accès aux données {@link Adresse}.
     */
    @EJB
    private IDaoAdherent daoAdresse;
    /**
     * Liste de produits.
     */
    private List<Produit> produits = new ArrayList<>();
    @Override
    public List<PointRelais> rechercherPointRelais(Ville ville) throws AnarmorixException {
        return daoCommerce.rechercherPointsRelais(ville);
    }
    @Override
    public Commande ajouterListeLigneCommande(Commande paramCommande) throws AnarmorixException {
        paramCommande = daoCommande.ajouter(paramCommande);
        for (LigneCommande ligne : paramCommande.getLignesCommande()) {
            ligne.setCommande(paramCommande);
            daoLignecommande.ajouter(ligne);
        }
        return paramCommande;
    }


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

    @Override
    public List<Produit> recupererLesProduitsParCategorie(String libelleCategorie, boolean reset) throws AnarmorixException {
        if (reset) {
            produits = new ArrayList<>();
        }
        List<Categorie> categories = null;
        List<TypeProduit> typeProduits = new ArrayList<>();
        try {
            categories = daoCategorie.rechercherCategorieParLibelle(libelleCategorie);
            if (isCategorieFille(categories.get(0))) {
                if (categories != null) {
                    typeProduits = categories.get(0).getTypesProduits();
                    for (TypeProduit type : typeProduits) {
                    //    System.out.println("business type " + type.getLibelle());
                        Integer idType  = type.getId();
                        produits.addAll(daoProduit.rechercherParIDTypeProduit(idType));
                    }
                }
            } else {
                for (Categorie cat : categories.get(0).getCategoriesFilles()) {
                     recupererLesProduitsParCategorie(cat.getLibelle(), false);
                }
            }
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return produits;
    }
    @Override
    public boolean isCategorieFille(Categorie paramCategorie) {
        return paramCategorie.getCategoriesFilles().size() == 0;
    }

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
     * @return the daoHoraire
     */
    public IDaoHoraire getDaoHoraire() {
        return daoHoraire;
    }

    /**
     * @param paramDaoHoraire the daoHoraire to set
     */
    public void setDaoHoraire(IDaoHoraire paramDaoHoraire) {
        daoHoraire = paramDaoHoraire;
    }

    /**
     * @return the daoJourOverture
     */
    public IDaoJourOuverture getDaoJourOverture() {
        return daoJourOverture;
    }

    /**
     * @param paramDaoJourOverture the daoJourOverture to set
     */
    public void setDaoJourOverture(IDaoJourOuverture paramDaoJourOverture) {
        daoJourOverture = paramDaoJourOverture;
    }

    /**
     * @return the daoVille
     */
    public IDaoVille getDaoVille() {
        return daoVille;
    }

    /**
     * @param paramDaoVille the daoVille to set
     */
    public void setDaoVille(IDaoVille paramDaoVille) {
        daoVille = paramDaoVille;
    }

    /**
     * @return the daoCommerce
     */
    public IDaoCommerce getDaoCommerce() {
        return daoCommerce;
    }

    /**
     * @param paramDaoCommerce the daoCommerce to set
     */
    public void setDaoCommerce(IDaoCommerce paramDaoCommerce) {
        daoCommerce = paramDaoCommerce;
    }

    /**
     * @return the daoProduit
     */
    public IDaoProduit getDaoProduit() {
        return daoProduit;
    }

    /**
     * @param paramDaoProduit the daoProduit to set
     */
    public void setDaoProduit(IDaoProduit paramDaoProduit) {
        daoProduit = paramDaoProduit;
    }

    /**
     * @return the daoCategorie
     */
    public IDaoCategorie getDaoCategorie() {
        return daoCategorie;
    }

    /**
     * @param paramDaoCategorie the daoCategorie to set
     */
    public void setDaoCategorie(IDaoCategorie paramDaoCategorie) {
        daoCategorie = paramDaoCategorie;
    }

    /**
     * @return the daoTypeProduit
     */
    public IDaoTypeProduit getDaoTypeProduit() {
        return daoTypeProduit;
    }

    /**
     * @param paramDaoTypeProduit the daoTypeProduit to set
     */
    public void setDaoTypeProduit(IDaoTypeProduit paramDaoTypeProduit) {
        daoTypeProduit = paramDaoTypeProduit;
    }

    /**
     * @return the daoLignecommande
     */
    public IDaoLigneCommande getDaoLignecommande() {
        return daoLignecommande;
    }

    /**
     * @param paramDaoLignecommande the daoLignecommande to set
     */
    public void setDaoLignecommande(IDaoLigneCommande paramDaoLignecommande) {
        daoLignecommande = paramDaoLignecommande;
    }

    /**
     * @return the daoCommande
     */
    public IDaoCommande getDaoCommande() {
        return daoCommande;
    }

    /**
     * @param paramDaoCommande the daoCommande to set
     */
    public void setDaoCommande(IDaoCommande paramDaoCommande) {
        daoCommande = paramDaoCommande;
    }

    /**
     * @return the daoAdresse
     */
    public IDaoAdherent getDaoAdresse() {
        return daoAdresse;
    }

    /**
     * @param paramDaoAdresse the daoAdresse to set
     */
    public void setDaoAdresse(IDaoAdherent paramDaoAdresse) {
        daoAdresse = paramDaoAdresse;
    }

    /**
     * @return the produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * @param paramProduits the produits to set
     */
    public void setProduits(List<Produit> paramProduits) {
        produits = paramProduits;
    }
}