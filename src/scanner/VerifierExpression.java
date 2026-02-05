package scanner;

public class VerifierExpression {

    public static boolean verifierExpression(String expression) {
        return expression.matches("^(\\s*(-\\s*)?\\d+(\\.\\d+)?\\s*)(\\+|-|\\*|/)(\\s*-?\\s*\\d+(\\.\\d+)?\\s*)$");
    }

    public static boolean verifierFormat(String expression) {
        return expression.matches("^(\\s*(-\\s*)?\\d+(\\.\\d+)?\\s*)(\\+|-|\\*|/)(\\s*-?\\s*\\d+(\\.\\d+)?\\s*)$");
    }

    public static boolean verifierValeurNumeriques(String expression) {
        return expression.matches("^[\\d\\.\\s\\+\\-\\*\\/]*$");
    }

    public static boolean verifierOperateur(String expression) {
        return expression.matches("^.+(\\+|\\-|\\*|\\/).*$");
    }
}
