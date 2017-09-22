package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoCategorie;
import fr.afcepf.anarmorix.data.api.IDaoImage;
import fr.afcepf.anarmorix.data.api.IDaoProduit;
import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Implemenatation de l'interface IDaoImage.
 */
@Remote(IDaoImage.class)
@Stateless
public class DaoImage implements IDaoImage {
    /**
     * Le contexte de persisntence.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    /**
     * Default constructor.
     */
    public DaoImage() {
    }
    /**
     * @return une liste d'images.
     * @throws AnarmorixException en cas de panne du serveur.
     */
    @Override
    public List<Image> rechercherImages() throws AnarmorixException {
        List<Image> liste = null;
        try {
            liste = em.createQuery(
                    "SELECT i FROM Image i", Image.class).getResultList();
        } catch (Exception e) {
            AnarmorixException exc = new AnarmorixException("", AnarmorixExceptionEnum.MYSQL_HS);
            throw exc;
        }
        return liste;
    }


}