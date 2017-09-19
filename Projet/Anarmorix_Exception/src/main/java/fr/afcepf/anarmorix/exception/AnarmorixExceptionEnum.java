package fr.afcepf.anarmorix.exception;
/**
 * Liste des codes d'erreurs de l'application.
 * @author Aubin
 *
 */
public enum AnarmorixExceptionEnum {
    /**
     * Cas générique, erreur non identifiée.
     */
    CA_MARCHE_PAS,
    /**
     * Au cas où on enregistre une valeur null obligatoire.
     */
    NULL_DATA,
    /**
     * Cas où une valeur est trop grande pour le système.
     */
    TOO_LONG_DATA,
    /**
     * Le serveur de données ne répond pas.
     */
    MYSQL_HS,
    /**
     * contraintes d'intégrité de données.
     */
    VIOLATION_DE_CONTRAINTE
}
