package fr.afcepf.anarmorix.data.api;

import fr.afcepf.anarmorix.entity.Adherent;

/**
 * Fonctionnalités liées à l'entity {@link Adherent}.
 * @author Stagiaire
 *
 */
public interface IDaoAdherent {

    /**
     * Méthode permettant la connexion d'un adhérent.
     * @param username l'username de l'{@link Adherent} se connectant
     * @param mdp le mot de passe de l'{@link Adherent} se connectant
     * @return l'entity {@link Adherent} connecté
     */
    Adherent seConnecter(String username, String password);

    /**
     * Méthode permettant de faire persister une entity {@link Adherent} en base.
     * @param adherent l'{@link Adherent} à ajouter.
     * @return l'{@link Adherent} ajouté à la base.
     */
    Adherent ajouter(Adherent adherent);

    /**
     * Méthode permettant la suppression d'un {@link Adherent} en base.
     * @param adherent l'{@link Adherent} à supprimer
     */
    void supprimer(Adherent adherent);

    /**
     * Méthode permettant de mettre à jour un {@link Adherent} dans la base.
     * @param adherent l'{@link Adherent} à mettre à jour.
     * @return l'entity {@link Adherent} mis à jour avec ses nouvelles informations..
     */
    Adherent mettreAJour(Adherent adherent);
}
