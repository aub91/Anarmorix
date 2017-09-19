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
    public Adherent seConnecter(String nom, String mdp);

    /**
     * @param nom 
     * @return
     */
    public List<Adherent> rechercher(String nom);

    /**
     * @return
     */
    public Adherent ajouter();

    /**
     * @param adherent
     */
    public void supprimer(Adherent adherent);

    /**
     * @param adherent 
     * @return
     */
    public Adherent mettreAJour(Adherent adherent);

}