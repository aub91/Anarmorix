package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Alea;
import fr.afcepf.anarmorix.entity.LigneCommande;

/**
 * 
 */
public interface IDaoAlea {

    /**
     * @param descriptionAlea 
     * @return
     */
    public List<Alea> rechercher(LigneCommande ligne) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws Exception;

    /**
     * @param alea 
     * @return
     */
    public Alea ajouter(Alea alea) throws Exception;

    /**
     * @param id 
     * @return
     */
    public Alea mettreAJour(Integer id) throws Exception;

}