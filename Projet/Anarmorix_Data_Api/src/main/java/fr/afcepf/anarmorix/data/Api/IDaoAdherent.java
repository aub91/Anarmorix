package fr.afcepf.anarmorix.data.Api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;

/**
 * 
 */
public interface IDaoAdherent {

    /**
     * @param nom 
     * @param mdp 
     * @return
     */
    Adherent seConnecter(String username, String password) throws Exception;

    /**
     * @param nom 
     * @return
     */
    Adherent ajouter(Adherent adherent) throws Exception;

    /**
     * @return
     */
    void supprimer(Adherent adherent) throws Exception;

    /**
     * @param adherent
     */
    Adherent mettreAJour(Adherent adherent) throws Exception;
}
