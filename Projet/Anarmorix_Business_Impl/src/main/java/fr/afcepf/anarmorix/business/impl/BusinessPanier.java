package fr.afcepf.anarmorix.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

@Remote(IBusinessPanier.class)
@Stateless
public class BusinessPanier implements IBusinessPanier {
	/**
	 * Default constructor.
	 */
	public BusinessPanier() {
	}
	/**
     * Interface d'accès aux données {@link LigneCommande}
     */
    private IDaoLigneCommande daoLignecommande;
	 
	@Override
	public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
		  	List<LigneCommande> nbCommande = daoLignecommande.rechercher(commande);
	    	return nbCommande;
	}
    
    
    
    
}
