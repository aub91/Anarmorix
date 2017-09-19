package fr.afcepf.anarmorix.exception;
/**
 * Classe pour la gestion des {@link Exception}.
 * @author Aubin
 */
public class AnarmorixException extends Exception {

    /**
     * Id de version pour la sérialisation.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Code d'erreur de l'exception.
     */
    private AnarmorixExceptionEnum codeErreur = AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE;
    /**
     * @param paramMessage le message pour l'exception
     * @param paramCodeErreur le code d'erreur de l'exception
     */
    public AnarmorixException(String paramMessage, AnarmorixExceptionEnum paramCodeErreur) {
        super(paramMessage);
        codeErreur = paramCodeErreur;
    }
    /**
     * Default constructor.
     */
    public AnarmorixException() {
    }
    /**
     * @return the codeErreur
     */
    public AnarmorixExceptionEnum getCodeErreur() {
        return codeErreur;
    }
    /**
     * @param paramCodeErreur the codeErreur to set
     */
    public void setCodeErreur(AnarmorixExceptionEnum paramCodeErreur) {
        codeErreur = paramCodeErreur;
    }
}
