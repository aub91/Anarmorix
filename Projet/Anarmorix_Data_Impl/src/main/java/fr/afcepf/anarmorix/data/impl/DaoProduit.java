package fr.afcepf.anarmorix.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * 
 */
@Remote(IDaoProduit.class)
@Stateless
public class DaoProduit implements IDaoProduit {
    /**
     * Le contexte de persisntence.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public DaoProduit() {
    }
    /**
     * Implémentation méthode recherche par ID de produit.
     * @param id l'id to set.
     * @return une liste de produits.
     * @throws AnarmorixException Le serveur ne répond pas.
     */
    @Override
    public List<Produit> rechercherParID(Integer id) throws AnarmorixException {
        List<Produit> liste = null;
        try {
            liste = em.createQuery(
                    "SELECT p FROM Produit p "
                            + "WHERE p.id = :pid", Produit.class)
                    .setParameter("pid", id)
                    .getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }
    /**
     * Implémentation méthode recherche par ID de type de produit.
     * @param paramId du type de produit to set.
     * @return une liste de produits.
     * @throws AnarmorixException Le serveur ne répond pas.
     */
    @Override
    public List<Produit> rechercherParIDTypeProduit(Integer paramId) throws AnarmorixException {
        List<Produit> liste = null;
        try {
            liste = em.createQuery(
                    "SELECT p FROM Produit p "
                            + "WHERE p.type.id = :pid", Produit.class)
                    .setParameter("pid", paramId)
                    .getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }
    /**
     * Implémentation méthode recherche tous les produits.
     * @return une liste de produits.
     * @throws AnarmorixException Le serveur ne répond pas.
     */
    @Override
    public List<Produit> rechercherTousLesProduits() throws AnarmorixException {
        List<Produit> liste = null;
        try {
            liste = em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }

    @Override
    public Produit ajouter(Produit paramProduit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produit mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }


}