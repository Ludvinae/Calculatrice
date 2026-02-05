package scanner;

import exception.AlaisException;
import exception.FormatIncorrect;
import exception.OperateurInconnu;
import exception.ValeurNonNumerique;

// La class VerifierExpression va permettre de vérifier que l'expression soit correct avant de commencer les calculs.
public class VerifierExpression {
    /**
     * Methods qui vérifie l'expression et les éventuelles erreurs et renvoyant l'exception adéquate
     * @param : expression
     */
    protected static void verifierExpression(String expression) {
        if (!verifierOperateur(expression)) throw new OperateurInconnu("Il manque un opéraeur valide a l'expression entrée.");
        if (verifierVirgule(expression)) throw new AlaisException("Veuillez utiliser un point à la place de la virgule pour séparer les décimales.");
        if (!verifierValeurNumeriques(expression)) throw new ValeurNonNumerique("L'expression doit contenir uniquement des valeurs numériques et l'opérateur.");
        if (!verifierFormat(expression)) throw new FormatIncorrect("Le format de l'expression devrait suivre le format 'valeur opérateur valeur");
    }

    /**
     * Method qui vérifie que le format x+y est bien respecté, si true le format est correct.
     * @param : expression
     * @return Boolean
     */
    private static boolean verifierFormat(String expression) {
        return expression.matches("^(\\s*(-\\s*)?\\d+(\\.\\d+)?\\s*)(\\+|-|\\*|/)(\\s*-?\\s*\\d+(\\.\\d+)?\\s*)$");
    }

    /**
     * Method qui vérifie que les valeurs soient bien numérique, si true l'expression ne contient que les caractères autorisés.
     * @param : expression
     * @return Boolean
     */
    private static boolean verifierValeurNumeriques(String expression) {
        return expression.matches("^[\\d\\.\\s\\+\\-\\*\\/]*$");
    }

    /**
     * Method qui vérifie la présence d'un moins un opérateur valide, si true l'opérateur est valide.
     * @param : expression
     * @return Boolean
     */
    private static boolean verifierOperateur(String expression) {
        return expression.matches("^.+(\\+|\\-|\\*|\\/).*$");
    }

    /**
     * Method qui vérifie la présence du caractère ",", si true l'expression n'est pas valide.
     * @param : expression
     * @return Boolean
     */
    private static boolean verifierVirgule(String expression) {
        if (expression.contains(",")) return true;
        return false;
    }
}
