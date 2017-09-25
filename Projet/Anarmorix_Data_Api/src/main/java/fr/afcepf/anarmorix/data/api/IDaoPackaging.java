package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface permettant la gestion de l'entité {@link Packaging}
 */
public interface IDaoPackaging {

    /**
     * @param libelle 
     * @return
     */
    public List<Packaging> rechercher(String libelle) throws AnarmorixException;

    /**
     * @param packaging 
     * @return
     */
    public Packaging ajouter(Packaging packaging) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Packaging mettreAJour(Integer id) throws AnarmorixException;

}