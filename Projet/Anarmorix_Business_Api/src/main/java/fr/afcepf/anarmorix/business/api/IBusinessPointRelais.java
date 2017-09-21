package fr.afcepf.anarmorix.business.api;

import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;

/**
 * Interface contenant les méthodes liés au point-relais de la couche business.
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