package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Horaire;
import fr.afcepf.anarmorix.entity.PointRelais;

/**
 * 
 */
public interface IDaoHoraire {

    /**
     * @param pointRelais 
     * @return
     */
    public List<Horaire> rechercher(PointRelais pointRelais);

    /**
     * @param horaire 
     * @return
     */
    public Horaire ajouter(Horaire horaire);

    /**
     * @param id 
     * @return
     */
    public boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Horaire mettreAJour(Integer id);

}