package fr.afcepf.anarmorix.data.Impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.anarmorix.data.Api.IDaoAdherent;
import fr.afcepf.anarmorix.entity.Adherent;

/**
 * 
 */
public class DaoAdherent implements IDaoAdherent {

    /**
     * Default constructor
     */
    public DaoAdherent() {
    }

    @Override
    public Adherent seConnecter(String paramNom, String paramMdp) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Adherent> rechercher(String paramNom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adherent ajouter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void supprimer(Adherent paramAdherent) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Adherent mettreAJour(Adherent paramAdherent) {
        // TODO Auto-generated method stub
        return null;
    }

}