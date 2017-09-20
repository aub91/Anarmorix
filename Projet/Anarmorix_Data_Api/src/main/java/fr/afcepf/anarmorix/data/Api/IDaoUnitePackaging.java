package fr.afcepf.anarmorix.data.Api;

import fr.afcepf.anarmorix.entity.UnitePackaging;

/**
 * 
 */
public interface IDaoUnitePackaging {

    /**
     * @param unite 
     * @return
     */
    public UnitePackaging rechercher(String unite);

    /**
     * @param unitePackaging 
     * @return
     */
    public UnitePackaging ajouter(UnitePackaging unitePackaging);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public UnitePackaging mettreAJour(Integer id);

}