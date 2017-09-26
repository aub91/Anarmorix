package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoCommande {

    /**
     * @return id
     */
    public List<Commande> rechercher(Adherent client) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param commande 
     * @return
     */
    public Commande ajouter(Commande commande) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Commande mettreAJour(Commande id) throws AnarmorixException;

}