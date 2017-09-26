package fr.afcepf.anarmorix.business.impl;

import java.util.Date;
import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessCommande;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.LignePanier;

public class BusinessCommande implements IBusinessCommande{

    @Override
    public Commande creerCommande(List<LignePanier> paramPanier) {
        Commande cmd = new Commande(null, new Date(), null, "valider", null, null, null);
        for (LignePanier lignePanier : paramPanier) {
            LigneCommande lgn = new LigneCommande(null, lignePanier.getQuantite(), null,
                    null,null, null,null, null, null, null, lignePanier.getProduit(), null);
        }
        return cmd;
    }

}
