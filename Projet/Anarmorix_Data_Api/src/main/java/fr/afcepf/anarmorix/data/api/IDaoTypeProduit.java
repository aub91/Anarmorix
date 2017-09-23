package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.TypeProduit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoTypeProduit {

    /**
     * @param nom 
     * @return
     */
    public List<TypeProduit> rechercher(Categorie categorie) throws AnarmorixException;

    /**
     * @return
     */
    public TypeProduit ajouter(TypeProduit typePdt) throws AnarmorixException;

    /**
     * @param typePdt
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param typePdt 
     * @return
     */
    public TypeProduit mettreAJour(Integer id) throws AnarmorixException;

}