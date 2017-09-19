package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.entity.Produit;

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
    public List<Produit> rechercher(Integer id) {
        System.out.println("test" + em);
        return em.createQuery(
                "SELECT p FROM Produit p "
                + "WHERE p.id like :pid", Produit.class)
                .setParameter("pid", id)
                .getResultList();
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