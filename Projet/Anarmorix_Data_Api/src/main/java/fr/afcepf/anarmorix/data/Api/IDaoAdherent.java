package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoAdherent {

    /**
     * @param nom 
     * @param mdp 
     * @return
     */
    Adherent seConnecter(String username, String password) throws AnarmorixException;

    /**
     * @param nom 
     * @return
     */
    Adherent ajouter(Adherent adherent) throws AnarmorixException;

    /**
     * @return
     */
    void supprimer(Adherent adherent) throws AnarmorixException;

    /**
     * @param adherent
     */
    Adherent mettreAJour(Adherent adherent) throws AnarmorixException;
}
