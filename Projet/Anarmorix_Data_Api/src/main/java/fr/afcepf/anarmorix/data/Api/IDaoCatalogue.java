package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.Catalogue;

/**
 * 
 */
public interface IDaoCatalogue {

    /**
     * @param catalogue 
     * @return
     */
    public Catalogue ajouter(Catalogue catalogue);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Catalogue mettreAJour(Integer id);

    /**
     * @return
     */
    public Catalogue rechercher();

}