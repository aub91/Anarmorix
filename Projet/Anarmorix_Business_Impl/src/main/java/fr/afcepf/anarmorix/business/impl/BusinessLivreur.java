package fr.afcepf.anarmorix.business.impl;

import java.util.Date;
import java.util.List;

import fr.afcepf.anarmorix.business.api.IBusinessLivreur;
import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.entity.Adresse;

/**
 * 
 */
public class BusinessLivreur implements IBusinessLivreur {

    /**
     * Default constructor
     */
    public BusinessLivreur() {
    }


    /**
     * 
     */
    public IDaoAdresse daoAdresse;

    /**
     * @param date 
     * @return
     */
    public List<Adresse> recupererCommande(Date date) {
        // TODO implement here
        return null;
    }

    /**
     * @param date 
     * @return
     */
    public List<Adresse> liverCommande(Date date) {
        // TODO implement here
        return null;
    }

}