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

/**
 * 
 */
@Remote(IDaoProduit.class)
@Stateless
public class DaoProduit implements IDaoProduit {
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor
     */
    public DaoProduit() {
    }

    @Override
    public List<Produit> rechercherParID (Integer id) throws AnarmorixException {
        List<Produit> liste = new ArrayList<Produit>();
        liste = em.createQuery(
                "SELECT p FROM Produit p "
                        + "WHERE p.id = :pid" , Produit.class)
                .setParameter("pid", id)
                .getResultList();
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

    @Override
    public List<Produit> rechercherParIDTypeProduit(Integer paramId) throws AnarmorixException {
        List<Produit> liste = new ArrayList<Produit>();
        liste = em.createQuery(
                "SELECT p FROM Produit p "
                        + "WHERE p.type.id = :pid" , Produit.class)
                .setParameter("pid", paramId)
                .getResultList();
        return liste;
    }

}