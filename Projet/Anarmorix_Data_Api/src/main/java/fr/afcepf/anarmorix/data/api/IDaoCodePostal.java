package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.CodePostal;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link CodePostal} dans le système.
 */
public interface IDaoCodePostal {

    /**
     * @param cp
     * @return
     */
    List<CodePostal> rechercher(Ville ville) throws AnarmorixException;

    /**
     * @param codePoostal
     * @return
     */
    CodePostal ajouter(CodePostal codePostal) throws AnarmorixException;

    /**
     * @param id
     * @return
     */
    Boolean supprimer(Integer id) throws AnarmorixException;

    /**
     * @param id
     * @return
     */
    CodePostal MettreAJour(Integer id) throws AnarmorixException;
    /**
     * Méthode de recherche du code postal lié à une adresse.
     * @param paramAdresse l'adresse dont on cherche le code postal
     * @return l'adresse avec son code postal.
     * @throws AnarmorixException exception
     */
    Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException;

}