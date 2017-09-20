package fr.afcepf.anarmorix.business.api;

import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;

/**
 * 
 */
public interface IBusinessPointRelais {

    /**
     * @param commande 
     * @return
     */
    public Commande receptionnerCommande(Commande commande);

    /**
     * @param commande 
     * @return
     */
    public Commande transmettreCommande(Commande commande);

    /**
     * @param alea 
     * @return
     */
    public Alea declareAlea(Alea alea);

}