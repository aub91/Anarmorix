package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

public interface IBusinessCommande {

    Commande creerCommande(List<LigneCommande> panier) throws AnarmorixException;
}
