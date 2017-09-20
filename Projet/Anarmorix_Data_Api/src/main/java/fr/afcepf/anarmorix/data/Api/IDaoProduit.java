package fr.afcepf.anarmorix.data.Api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Produit;

/**
 * 
 */
public interface IDaoProduit {

    /**
     * @param descriptif 
     * @return
     */
    public List<Produit> rechercher(String descriptif);

    /**
     * @param produit 
     * @return
     */
    public Produit ajouter(Produit produit);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Produit mettreAJour(Integer id);

}