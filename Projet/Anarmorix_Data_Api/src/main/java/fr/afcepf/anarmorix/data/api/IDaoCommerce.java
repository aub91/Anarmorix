package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Méthodes liées à la persistence de l'entité {@link Commerce}.
 */
public interface IDaoCommerce {

    /**
     * @param ville la ville de recherche
     * @return la liste de commerce de la ville en paramètre
     * @throws AnarmorixException une exception
     */
    List<Commerce> rechercherCommerces(Ville ville) throws AnarmorixException;
    /**
     * @param ville la ville de recherche
     * @return la liste des sociétés de livraison de la ville
     * @throws AnarmorixException une exception
     */
    List<SocieteDeLivraison> rechercherSocietesDeLivraison(Ville ville) throws AnarmorixException;

    /**
     * @param commerce le commerce a ajouté
     * @return le commerce ajouté avec son id
     * @throws AnarmorixException une exception
     */
    Commerce ajouter(Commerce commerce) throws AnarmorixException;

    /**
     * @param id id du commerce à supprimer
     * @return true si la suppression est un succès
     * @throws AnarmorixException une exception
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id id du commerce à mettre à jour
     * @return le commerce mis à jour
     * @throws AnarmorixException une exception
     */
    Commerce mettreAJour(Integer id) throws AnarmorixException;
    /**
     * Méthode alimentant un catalogue avec son exploitation.
     * @param paramCatalogue un catalogue sans son exploitation
     * @return le catalogue avec son exploitation
     * @throws AnarmorixException une exception
     */
    Catalogue rechercherExploitationByCatalogue(Catalogue paramCatalogue) throws AnarmorixException;

}