package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

public interface IBusinessPanier {
	 /**
	  * methode qui recherche les ligne de commande dans la base et les affiche dans la page panier.
     * @param commande 
     * @return
	 * @throws AnarmorixException 
     */
    public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException;

}
