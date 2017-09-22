package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Catalogue;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoCatalogue {

    /**
     * @param catalogue 
     * @return
     */
    public Catalogue ajouter(Catalogue catalogue) throws AnarmorixException ;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Catalogue mettreAJour(Integer id) throws AnarmorixException;

    /**
     * @return
     */
    public List<Catalogue> rechercher(Exploitation exploitation) throws AnarmorixException;

}