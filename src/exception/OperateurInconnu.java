package exception;

public class OperateurInconnu extends RuntimeException {
    public OperateurInconnu(String message) {
        super(message);
    }
}
