package exception;
/**
 * Exception soulever si une valeur est divisé par zéro.
 */
public class DivisionParZero extends RuntimeException {
    public DivisionParZero(String message) {
        super(message);
    }
}
