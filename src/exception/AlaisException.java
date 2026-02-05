package exception;
// Nommée AlaisException suite à une problématique en interne.
/**
 * Exception soulevée par l'utilisation d'une virgule dans l'expression et non d'un point
 */
public class AlaisException extends RuntimeException {
    public AlaisException(String message) {
        super(message);
    }
}
