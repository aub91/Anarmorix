package fr.afcepf.anarmorix.data.Api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commerce;

/**
 * 
 */
public interface IDaoCommerce {

    /**
     * @param raisonSociale 
     * @return
     */
    public List<Commerce> rechercher(String raisonSociale);

    /**
     * @param commerce 
     * @return
     */
    public Commerce ajouter(Commerce commerce);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Commerce mettreAJour(Integer id);

}