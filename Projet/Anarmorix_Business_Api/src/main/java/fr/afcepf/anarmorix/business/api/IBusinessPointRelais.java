package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface contenant les méthodes liés au point-relais de la couche business.
 */
public interface IBusinessPointRelais {
	/**
     * @param commande
     * @return
     */
	Adherent afficherAdherent(Commande commande) throws AnarmorixException;
	/**
     * @param client
     * @return
     */
	 List<Commande> afficherCommande(Adherent client) throws AnarmorixException;


}