package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessPointRelais;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public class BusinessPointrelais implements IBusinessPointRelais {

    /**
     * Default constructor
     */
    public BusinessPointrelais() {
    }

    public IDaoAdherent daoAdherent;
    /**
     * 
     */
    public IDaoCommande daoCommande;

    /**
     * 
     */
    public IDaoAlea daoAlea;

    /**
     * @param commande 
     * @return
     */
    public Commande receptionnerCommande(Commande commande) {
        // TODO implement here
        return null;
    }

    /**
     * @param commande 
     * @return
     */
    public Commande transmettreCommande(Commande commande) {
        // TODO implement here
        return null;
    }

    /**
     * @param alea 
     * @return
     */
    public Alea declareAlea(Alea alea) {
        // TODO implement here
        return null;
    }

	@Override
	public List<Commande> afficherCommande(Adherent client) throws AnarmorixException {
		
		return daoCommande.rechercher(client);
	
	}

	@Override
	public List<Adherent> afficherAdherent(Commande commande) throws AnarmorixException {
		
		return daoAdherent.rechercher(commande);
	}

	
}