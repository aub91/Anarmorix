package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Fonctionnalités métier liés à la gestion de l'entité {@link Ville} dans le système.
 */
public interface IDaoVille {

    /**
     * @param nom le nom de ville à chercher
     * @return la liste de ville contenant le nom recherché
     */
   List<Ville> rechercher(String nom);

    /**
     * @param ville la ville à ajouter
     * @return la ville ajouté avec son id
     */
    Ville ajouter(Ville ville);

    /**
     * @param id id de la ville à supprimer
     * @return vrai si suppression réussi
     */
    Boolean supprimer(Integer id);

    /**
     * @param id id de la ville à mettre à jour
     * @return la ville avec ses informations mise à jour
     */
    Ville mettreAJour(Integer id);
    /**
     * @param paramAdresse l'adresse dont on cherche la ville
     * @return l'adresse avec sa ville
     * @throws AnarmorixException exception
     */
    Adresse getByAdress(Adresse paramAdresse) throws AnarmorixException;

}