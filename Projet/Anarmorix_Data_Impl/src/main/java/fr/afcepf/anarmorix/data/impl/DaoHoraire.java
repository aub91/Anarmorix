package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import fr.afcepf.anarmorix.data.api.IDaoHoraire;
import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.PointRelais;

/**
 * 
 */
public class DaoHoraire implements IDaoHoraire {

    /**
     * Default constructor
     */
    public DaoHoraire() {
    }

    @Override
    public List<Horaire> rechercher(PointRelais paramPointRelais) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Horaire ajouter(Horaire paramHoraire) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean supprimer(Integer paramId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Horaire mettreAJour(Integer paramId) {
        // TODO Auto-generated method stub
        return null;
    }

}