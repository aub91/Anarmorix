package fr.afcepf.anarmorix.exception;
/**
 * Liste des codes d'erreurs de l'application.
 * @author Aubin
 *
 */
public enum AnarmorixExceptionEnum {
    /**
     * Cas générique.
     */
    ERREUR_NON_IDENTIFIEE,
    /**
     * Cas où la couche métier voit que le mail existe déjà dans le systeme.
     */
    MAIL_EXISTANT,
    /**
     * Cas où on enregistre une valeur null obligatoire.
     */
    NULL_DATA,
    /**
     * Cas où une valeur est trop grande pour le système.
     */
    TOO_LONG_DATA,
    /**
     * Cas où le serveur de données ne répond pas.
     */
    MYSQL_HS,
    /**
     * Cas des contraintes d'intégrité.
     */
    VIOLATION_DE_CONTRAINTE,
    /**
     * Cas d'un username inexistant ou d'un mot de passe invalide.
     */
    ERREUR_IDENTIFIANTS_CONNEXION,
    /**
     * Cas d'un argument de méthode inexistant.
     */
    ARGUMENT_INEXISTANT,
    /**
     * Cas d'une commande qui n'est plus annulable.
     */
    COMMANDE_NON_ANNULABLE
}
