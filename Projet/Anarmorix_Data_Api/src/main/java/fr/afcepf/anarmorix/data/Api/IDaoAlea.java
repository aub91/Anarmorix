package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.Alea;

/**
 * 
 */
public interface IDaoAlea {

    /**
     * @param descriptionAlea 
     * @return
     */
    public Alea rechercher(String descriptionAlea);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param alea 
     * @return
     */
    public Alea ajouter(Alea alea);

    /**
     * @param id 
     * @return
     */
    public Alea mettreAJour(Integer id);

}