package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.Alea;

/**
 * 
 */
public interface IDaoAlea {

    /**
     * @param descriptionAlea 
     * @return
     */
    public Alea rechercher(String descriptionAlea) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws Exception;

    /**
     * @param alea 
     * @return
     */
    public Alea ajouter(Alea alea) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Alea mettreAJour(Integer id) throws Exception;

}