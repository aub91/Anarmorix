package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Commerce;
import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.PointRelais;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * 
 */
public interface IDaoCommerce {

    /**
     * @param ville 
     * @return
     */
    public List<Commerce> rechercherCommerces(Ville ville) throws AnarmorixException;
    
    /**
     * @param ville
     * @return
     */
    public List<Exploitation> rechercherExploitations(Ville ville) throws AnarmorixException;
    
    /**
     * @param raisonSociale 
     * @return
     */
    public List<PointRelais> rechercherPointsRelais(Ville ville) throws AnarmorixException;
    
    /**
     * @param raisonSociale 
     * @return
     */
    public List<SocieteDeLivraison> rechercherSocietesDeLivraison(Ville ville) throws AnarmorixException;

    /**
     * @param commerce 
     * @return
     */
    public Commerce ajouter(Commerce commerce) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Commerce mettreAJour(Integer id) throws AnarmorixException;

}