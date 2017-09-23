package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.UnitePackaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface permettant de gérer l'entité unite Packaging.
 */
public interface IDaoUnitePackaging {

    /**
     * @param unite 
     * @return
     */
    public List<UnitePackaging> rechercher(String unite) throws AnarmorixException;

    /**
     * @param unitePackaging 
     * @return
     */
    public UnitePackaging ajouter(UnitePackaging unitePackaging) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public UnitePackaging mettreAJour(Integer id) throws AnarmorixException;

}