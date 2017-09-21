package fr.afcepf.anarmorix.business.api;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Interface métier de la connexion.
 * @author Stagiaire
 *
 */
public interface IBusinessConnexion {


    /**
     * Méthode permettant la connexion d'un {@link Adherent}.
     * @param username l'username à entrer.
     * @param password le mot de passe correspondant.
     * @return l'{@link Adherent} connecté.
     */
    Adherent seConnecter(String username, String password) throws AnarmorixException;
}
