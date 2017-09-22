package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface produit.
 */
public interface IDaoProduit {

    /**
     * methode qui retroune une liste de produit par ID.
     * @param id ID to Set id produit.
     * @return une liste de produit.
     * @throws AnarmorixException
     */
    public List<Produit> rechercherParID(Integer id) throws AnarmorixException;

    /**
     * @param produit 
     * @return
     */
    public Produit ajouter(Produit produit) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id 
     * @return
     */
    public Produit mettreAJour(Integer id) throws AnarmorixException;
    /**
     * methode qui retroune une liste de produit par IDtypeProduit.
     * @param id ID to Set id produit.
     * @return une liste de produit.
     * @throws AnarmorixException
     */
    public List<Produit> rechercherParIDTypeProduit(Integer id) throws AnarmorixException;

}