package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoLigneCommande {

    /**
     * @return
     */
    public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException;
    
    /**
     * @param paramId l'id de la ligne de commande recherchée.
     * @return la ligne de commande identifiée par l'id.
     * @throws AnarmorixException, l'exception spécifique éventuellement levée.
     */
    public LigneCommande rechercher(Integer paramId) throws AnarmorixException;

    /**
     * @param ligneCommande 
     * @return
     */
    public LigneCommande ajouter(LigneCommande ligneCommande) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException ;

    /**
     * @param id 
     * @return
     */
    public LigneCommande mettreAJour(Integer id) throws AnarmorixException;

}