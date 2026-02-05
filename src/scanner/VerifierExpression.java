package scanner;

import exception.AlaisException;
import exception.FormatIncorrect;
import exception.OperateurInconnu;
import exception.ValeurNonNumerique;


public class VerifierExpression {

    public static void verifierExpression(String expression) {
        if (!verifierOperateur(expression)) throw new OperateurInconnu("Il manque un opéraeur valide a l'expression entrée.");
        if (verifierVirgule(expression)) throw new AlaisException("Veuillez utiliser un point à la place de la virgule pour séparer les décimales.");
        if (!verifierValeurNumeriques(expression)) throw new ValeurNonNumerique("L'expression doit contenir uniquement des valeurs numériques et l'opérateur.");
        if (!verifierFormat(expression)) throw new FormatIncorrect("Le format de l'expression devrait suivre le format 'valeur opérateur valeur");
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

    public static boolean verifierVirgule(String expression) {
        return expression.matches(",");
    }
}
