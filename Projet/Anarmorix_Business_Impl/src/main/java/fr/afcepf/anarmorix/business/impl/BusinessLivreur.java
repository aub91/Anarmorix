package fr.afcepf.anarmorix.business.impl;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.data.api.IDaoTournee;
import fr.afcepf.anarmorix.data.impl.DaoTournee;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe implémentant les méthodes de {@link IBusinessLivreur}.
 */
public class BusinessLivreur implements IBusinessLivreur {
    /**
     * {@link IDaoTournee}.
     */
    private IDaoTournee daoTournee = new DaoTournee();
    /**
     * Default constructor.
     */
    public BusinessLivreur() {

    }

    @Override
    public SocieteDeLivraison setTournees(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException {
        return daoTournee.rechercherBySocieteDeLivraison(paramSocieteDeLivraison);
    }


}