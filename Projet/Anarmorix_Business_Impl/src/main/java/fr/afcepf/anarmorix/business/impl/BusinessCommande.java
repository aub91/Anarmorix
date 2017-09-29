package fr.afcepf.anarmorix.business.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.business.api.IBusinessCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;
/**
 * Implémentation de {@link IBusinessCommande}.
 * @author Aubin
 *
 */
@Remote(IBusinessCommande.class)
@Stateless
public class BusinessCommande implements IBusinessCommande {
    /**
     * {@link IDaoCommande}.
     */
    @EJB
    private IDaoCommande daoCmd;
    /**
     * {@link IDaoLigneCommande}.
     */
    @EJB
    private IDaoLigneCommande daoLg;

    @Override
    public Commande creerCommande(List<LigneCommande> paramPanier) throws AnarmorixException {
        Commande cmd = new Commande(null, new Date(), null, "codeValidation", null, null, null);
        daoCmd.ajouter(cmd);
        for (LigneCommande lignePanier : paramPanier) {
            daoLg.ajouter(lignePanier);
        }
        return cmd;
    }

}
