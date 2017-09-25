package fr.afcepf.anarmorix.business.impl;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


import fr.afcepf.anarmorix.business.api.IBusinessConsommateur;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.api.IDaoPackaging;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;


@Stateless
@Remote(IBusinessConsommateur.class)
public class BusinessConsommateur implements IBusinessConsommateur {
	@EJB
	  private IDaoLigneCommande daoLignecommande;
	@EJB
	private IDaoAdherent daoAdherent;
	
	
	


	@Override
	public List<LigneCommande> afficherLigneCommande(Commande commande) throws AnarmorixException {
		
		return daoLignecommande.rechercher(commande);
	}





	@Override
	public Client afficherClient(Commande commande) throws AnarmorixException {
		
		return (Client) daoAdherent.afficherAdherent(commande);
	}





}
