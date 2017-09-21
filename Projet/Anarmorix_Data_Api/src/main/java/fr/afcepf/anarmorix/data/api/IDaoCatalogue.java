package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.Catalogue;

/**
 * 
 */
public interface IDaoCatalogue {

    /**
     * @param catalogue 
     * @return
     */
    public Catalogue ajouter(Catalogue catalogue) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Catalogue mettreAJour(Integer id) throws Exception;

    /**
     * @return
     */
    public Catalogue rechercher() throws Exception;

}