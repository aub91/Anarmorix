package fr.afcepf.anarmorix.business.impl;

import java.util.Date;
import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessCommande;
import fr.afcepf.anarmorix.data.api.IDaoCommande;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.data.impl.DaoCommande;
import fr.afcepf.anarmorix.data.impl.DaoLigneCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

public class BusinessCommande implements IBusinessCommande{
    
    private IDaoCommande daoCmd = new DaoCommande();
    
    private IDaoLigneCommande daoLg = new DaoLigneCommande();

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
