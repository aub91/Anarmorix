package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.Commande;

/**
 * 
 */
public interface IDaoCommande {

    /**
     * @return
     */
    public Commande rechercher();

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param commande 
     * @return
     */
    public Commande ajouter(Commande commande);

    /**
     * @param id 
     * @return
     */
    public Commande mettreAJour(Commande id);

}