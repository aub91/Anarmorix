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
     * @param ligneCommande 
     * @return
     */
    public LigneCommande ajouter(LigneCommande ligneCommande);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public LigneCommande mettreAJour(Integer id);

}