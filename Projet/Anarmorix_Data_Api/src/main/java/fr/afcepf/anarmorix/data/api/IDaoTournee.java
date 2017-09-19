package fr.afcepf.anarmorix.data.api;

import java.util.Date;
import java.util.List;

import fr.afcepf.anarmorix.entity.Tournee;

/**
 * 
 */
public interface IDaoTournee {

    /**
     * @param dateDebut  
     * @return
     */
    public List<Tournee> rechercher(Date dateDebut );

    /**
     * @param tournee 
     * @return
     */
    public Tournee ajouter(Tournee tournee);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Tournee mettreAJour(Integer id);

}