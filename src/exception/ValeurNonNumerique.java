package exception;

/**
 * Exception soulever si l'expression contient des valeurs non numériques.
 */
public class ValeurNonNumerique extends RuntimeException {
    public ValeurNonNumerique(String message) {
        super(message);
    }
}
