package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.LigneCommande;

/**
 * 
 */
public interface IBusinessProducteur {

    /**
     * @param ligneCommande 
     * @return
     */
    public Boolean preparerLigneCommande(LigneCommande ligneCommande);

    /**
     * @param alea 
     * @return
     */
    public Alea declarerAlea(Alea alea);

    /**
     * @param catalogue 
     * @return
     */
    public Catalogue creerCatalogue(Catalogue catalogue);

    /**
     * @param client Client 
     * @return
     */
    public List <LigneCommande> rechercherLigneCommande(Client client);

}