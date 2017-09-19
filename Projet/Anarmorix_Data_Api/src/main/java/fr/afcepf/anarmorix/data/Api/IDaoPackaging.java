package fr.afcepf.anarmorix.data.Api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Packaging;

/**
 * 
 */
public interface IDaoPackaging {

    /**
     * @param libelle 
     * @return
     */
    public List<Packaging> rechercher(String libelle);

    /**
     * @param packaging 
     * @return
     */
    public Packaging ajouter(Packaging packaging);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Packaging mettreAJour(Integer id);

}