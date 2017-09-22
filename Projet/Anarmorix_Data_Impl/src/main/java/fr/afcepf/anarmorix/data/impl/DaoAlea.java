package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import fr.afcepf.anarmorix.data.api.IDaoAlea;
import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public class DaoAlea implements IDaoAlea {

    /**
     * Default constructor
     */
    public DaoAlea() {
    }

    @Override
    public List<Alea> rechercher(LigneCommande paramLigne) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alea ajouter(Alea paramAlea) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alea mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

}