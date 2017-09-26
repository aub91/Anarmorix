package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LignePanier;

public interface IBusinessCommande {

    Commande creerCommande(List<LignePanier> panier);
}
