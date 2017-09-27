package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link Commande} dans le système.
 */
public interface IDaoCommande {

    /**
     * @return id
     */
    List<Commande> rechercher(Adherent client) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param commande 
     * @return
     */
    Commande ajouter(Commande commande) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    Commande mettreAJour(Commande id) throws AnarmorixException;
}