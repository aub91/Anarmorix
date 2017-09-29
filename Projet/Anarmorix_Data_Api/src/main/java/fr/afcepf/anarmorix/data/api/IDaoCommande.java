package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link Commande} dans le système.
 */
public interface IDaoCommande {

    /**
     * @param client client de recherche
     * @return Liste de commande de l'adherent
     * @throws AnarmorixException une exception
     */
    List<Commande> rechercher(Adherent client) throws AnarmorixException;

    /**
     * @param id id de la commande à supprimer
     * @return true si la suppression est un succès
     * @throws AnarmorixException une exception
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param paramCommande commande à ajouter
     * @return la commande avec son id
     * @throws AnarmorixException une exception
     */
    Commande ajouter(Commande paramCommande) throws AnarmorixException;

    /**
     * @param paramCommande la commande à mettre à jour
     * @return la commande mise à jour
     * @throws AnarmorixException une exception
     */
    Commande mettreAJour(Commande paramCommande) throws AnarmorixException;
}