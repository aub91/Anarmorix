package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.MotifDesinscription;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface permettant la gestion de l'entité {@link MotifDesinscription}.
 */
public interface IDaoMotifDesinscription {

    /**
     * @param nom 
     * @return
     */
    public List<MotifDesinscription> rechercher() throws AnarmorixException;

    /**
     * @param motif 
     * @return
     */
    public MotifDesinscription ajouter(MotifDesinscription motif) throws AnarmorixException;
    /**
     * @param id
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param adherent 
     * @return
     */
    public MotifDesinscription mettreAJour(Integer id) throws AnarmorixException;

}