package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessPanier;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
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
	@EJB 
    private IDaoLigneCommande daoLigneCommande;
	
	 
	@Override
	public List<LigneCommande> rechercher(Commande commande) throws AnarmorixException {
		  	List<LigneCommande> nbCommande = daoLigneCommande.rechercher(commande);
	    	return nbCommande;
	}
    
    
    
    
}
