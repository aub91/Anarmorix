package fr.afcepf.anarmorix.business.api;

import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classes contenant les fonctionnalités métier de {@link Livreur}.
 */
public interface IBusinessLivreur {

    /**
     * Méthode pour obtenir les tournées de la société de livraison du livreur.
     * @param paramSocieteDeLivraison societe de livraison à alimenter
     * @return la société de livraison avec ses tournees
     * @throws AnarmorixException une exception
     */
    SocieteDeLivraison setTournees(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException;

}