package exception;
/**
 * Exception soulever si le format de l'expression reçu n'est pas valide.
 */
public class FormatIncorrect extends RuntimeException {
    public FormatIncorrect(String message) {
        super(message);
    }
}
