package fr.afcepf.anarmorix.business.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;

/**
 * 
 */
public interface IBusinessLivreur {

    /**
     * @param date 
     * @return
     */
    public List<Adresse> recupererCommande(Date date);

    /**
     * @param date 
     * @return
     */
    public List<Adresse> liverCommande(Date date);

}