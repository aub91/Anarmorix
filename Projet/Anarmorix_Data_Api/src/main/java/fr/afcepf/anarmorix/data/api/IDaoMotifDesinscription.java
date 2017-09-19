package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.MotifDesinscription;

/**
 * 
 */
public interface IDaoMotifDesinscription {

    /**
     * @param nom 
     * @return
     */
    public List<MotifDesinscription> rechercher(String nom);

    /**
     * @param motif 
     * @return
     */
    public MotifDesinscription ajouter(MotifDesinscription motif);

    /**
     * @param id
     */
    public void supprimer(Integer id);

    /**
     * @param adherent 
     * @return
     */
    public Adherent mettreAJour(Adherent adherent);

}