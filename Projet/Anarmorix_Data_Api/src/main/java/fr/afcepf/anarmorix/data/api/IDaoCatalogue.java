package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités liées à la persistence de l'entité {@link Catalogue}.
 */
public interface IDaoCatalogue {

    /**
     * @param catalogue le catalogue a ajouté
     * @return le catalogue ajouté avec son id
     * @throws AnarmorixException une exception
     */
    Catalogue ajouter(Catalogue catalogue) throws AnarmorixException;

    /**
     * @param id id du catalogue à supprimer
     * @return true si la suppression est un succès
     * @throws AnarmorixException une exception
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id id du catalogue à mettre à jour
     * @return le catalogue mis à jour
     * @throws AnarmorixException une exception
     */
    Catalogue mettreAJour(Integer id) throws AnarmorixException;

    /**
     * @param exploitation exploitation sans ses catalogues
     * @return la liste de catalogue de l'exploitation en paramètre
     * @throws AnarmorixException une exception
     */
    List<Catalogue> rechercherByExploitation(Exploitation exploitation) throws AnarmorixException;
    /**
     * Méthode alimentant un {@link Produit} avec son catalogue.
     * @param paramProduit le produit à alimenter
     * @return le produit avec son catalogue
     * @throws AnarmorixException une exception
     */
    Produit rechercherByProduit(Produit paramProduit) throws AnarmorixException;

}