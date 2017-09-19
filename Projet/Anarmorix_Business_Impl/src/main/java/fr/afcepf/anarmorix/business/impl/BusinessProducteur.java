package fr.afcepf.anarmorix.business.impl;

import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessProducteur;
import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.data.api.IDaoCatalogue;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.LigneCommande;

/**
 * 
 */
public class BusinessProducteur implements IBusinessProducteur {

    /**
     * Default constructor
     */
    public BusinessProducteur() {
    }


    /**
     * 
     */
    public IDaoAlea daoAlea;

    /**
     * 
     */
    public IDaoCatalogue daoCatalogue;

    /**
     * @param ligneCommande 
     * @return
     */
    public Boolean preparerLigneCommande(LigneCommande ligneCommande) {
        // TODO implement here
        return null;
    }

    /**
     * @param alea 
     * @return
     */
    public Alea declarerAlea(Alea alea) {
        // TODO implement here
        return null;
    }

    /**
     * @param catalogue 
     * @return
     */
    public Catalogue creerCatalogue(Catalogue catalogue) {
        // TODO implement here
        return null;
    }

    /**
     * @param client Client 
     * @return
     */
    @Override
    public List<LigneCommande> rechercherLigneCommande(Client paramClient) {
        // TODO Auto-generated method stub
        return null;
    }

}