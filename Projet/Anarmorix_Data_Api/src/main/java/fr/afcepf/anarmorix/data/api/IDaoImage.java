package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Categorie;
import fr.afcepf.anarmorix.entity.Image;
import fr.afcepf.anarmorix.entity.Produit;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface du DAO Image.
 */
public interface IDaoImage {

    /**
     * @return une liste d'images.
     * @throws AnarmorixException en cas de panne du seveur.
     */
    List<Image> rechercherImages() throws AnarmorixException;
}