package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.TypeProduit;

/**
 * 
 */
public interface IDaoTypeProduit {

    /**
     * @param nom 
     * @return
     */
    public List<TypeProduit> rechercher(String nom);

    /**
     * @return
     */
    public TypeProduit ajouter();

    /**
     * @param typePdt
     */
    public void supprimer(TypeProduit typePdt);

    /**
     * @param typePdt 
     * @return
     */
    public TypeProduit mettreAJour(TypeProduit typePdt);

}