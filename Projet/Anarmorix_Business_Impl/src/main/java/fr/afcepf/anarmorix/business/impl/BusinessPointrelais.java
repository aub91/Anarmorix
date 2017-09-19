package fr.afcepf.anarmorix.business.impl;

import fr.afcepf.anarmorix.business.api.IBusinessPointRelais;
import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;

/**
 * 
 */
public class BusinessPointrelais implements IBusinessPointRelais {

    /**
     * Default constructor
     */
    public BusinessPointrelais() {
    }

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

}