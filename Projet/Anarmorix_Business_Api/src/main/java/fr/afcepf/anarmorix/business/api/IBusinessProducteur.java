package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.Producteur;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier du producteur.
 */
public interface IBusinessProducteur {

    /**
     * Méthode de recherche des commandes d'un producteur.
     * @param paramProducteur producteur
     * @return la liste des commandes
     * @throws AnarmorixException une exception
     */
    List<Commande> rechercherCommandes(Producteur paramProducteur) throws AnarmorixException;

}