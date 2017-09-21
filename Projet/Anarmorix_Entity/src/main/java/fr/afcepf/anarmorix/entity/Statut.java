package fr.afcepf.anarmorix.entity;

/**
 * Enumération contenant les différents statuts d'une commande.
 */
public enum Statut {
    /**
     * Statut à partir de la créaetion de la {@link Commande}.
     */
    CREEE,
    /**
     * Statut à partir du moment où la commande est validée par le client.
     */
    EN_ATTENTE_DE_PREPARATION,
    /**
     * Statut à partir du moment où mla préparation de la commande a commencé.
     */
    EN_COURS_DE_PREPARATION,
    /**
     * Préparation terminée
     */
    PRETE,
    /**
     * Commande retirée par le livreur.
     */
    EN_COURS_DE_LIVRAISON,
    /**
     * Commande déposée au point relais.
     */
    EN_ATTENTE_DE_RETRAIT,
    /**
     * Commande retirée par le client.
     */
    TERMINEE
}