package fr.afcepf.anarmorix.business.impl;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessConnexion;
import fr.afcepf.anarmorix.data.api.IDaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classe permettant la gestion de la connexion d'un {@link Adherent} côté métier.
 * @author Stagiaire
 *
 */
@Remote(IBusinessConnexion.class)
@Stateless
public class BusinessConnexion implements IBusinessConnexion {

    /**
     * Default Constructor.
     */
    public BusinessConnexion() {
    }

    /**
     * Classe contenant la méthode connexion côté Data.
     */
    @EJB
    private IDaoAdherent dao;

    /**
     * Méthode métier permettant la connexion d'un adhérent.
     */
    @Override
    public Adherent seConnecter(String paramUsername, String paramPassword)throws AnarmorixException {
        return dao.seConnecter(paramUsername, paramPassword);
    }

}
