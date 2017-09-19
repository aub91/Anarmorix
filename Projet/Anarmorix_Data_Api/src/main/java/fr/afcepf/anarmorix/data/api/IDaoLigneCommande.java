package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.LigneCommande;

/**
 * 
 */
public interface IDaoLigneCommande {

    /**
     * @return
     */
    public LigneCommande rechercher();

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