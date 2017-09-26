package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités liés à la persistence de l'entité {@link LigneCommande}.
 */
public interface IDaoLigneCommande {

    /**
     * @return
     */
    public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException;
    
    /**
     * @param paramId l'id de la ligne de commande recherchée.
     * @return la ligne de commande identifiée par l'id.
     * @throws AnarmorixException l'exception spécifique éventuellement levée.
     */
    LigneCommande rechercher(Integer paramId) throws AnarmorixException;

    /**
     * @param ligneCommande 
     * @return
     */
    LigneCommande ajouter(LigneCommande ligneCommande) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    Boolean supprimer(Integer id) throws AnarmorixException ;

    /**
     * @param id 
     * @return
     */
    LigneCommande mettreAJour(Integer id) throws AnarmorixException;
    /**
     * Méthode recherchant les lignes de commandes d'une tournée.
     * @param paramTournee la tournée à alimenter
     * @return la tournée avec sa liste de lignes de commande
     * @throws AnarmorixException une exception levée
     */
    Tournee rechercherByTournee(Tournee paramTournee) throws AnarmorixException;

}