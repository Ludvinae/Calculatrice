package scanner;

import exception.AlaisException;
import exception.FormatIncorrect;
import exception.OperateurInconnu;
import exception.ValeurNonNumerique;

import static scanner.VerifierExpression.verifierExpression;

// La class Scanner va permettre à l'utilisateur de saisir une expression
public class Scanner {
    private java.util.Scanner scanner;

    /**
     * Constructeur de la class Scanner
     */
    public Scanner() {
        scanner = new java.util.Scanner(System.in);
    }

    /**
     * Method qui demande à l'utilisateur une expression et boucle si l'expression est incorrect
     * @return une expression en String
     */
    public String demanderExpression() {
        String expression = "";
        while (true) {
            System.out.print("Veuillez saisir une expression mathématique: ");
            expression = scanner.nextLine();
            // Ici remonte toutes les erreurs liées à l'expression entrée par l'utilisateur et sont catch.
            try {
                verifierExpression(expression);
            } catch (OperateurInconnu | AlaisException | ValeurNonNumerique  | FormatIncorrect e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return expression;
    }

    /**
     * Methods qui ferme le Scanner après utilisation
     */
    public void fermerScanner() {
        scanner.close();
    }
}

