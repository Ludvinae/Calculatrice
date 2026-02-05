package exception;
/**
 * Exception soulever si l'opérateur utilisé n'est pas reconnu.
 */
public class OperateurInconnu extends RuntimeException {
    public OperateurInconnu(String message) {
        super(message);
    }
}
