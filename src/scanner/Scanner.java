package scanner;

import exception.AlaisException;
import exception.FormatIncorrect;
import exception.OperateurInconnu;
import exception.ValeurNonNumerique;

import static scanner.VerifierExpression.verifierExpression;


public class Scanner {
    private java.util.Scanner scanner;

    public Scanner() {
        scanner = new java.util.Scanner(System.in);
    }

    public String demanderExpression() {
        String expression = "";
        while (true) {
            System.out.print("Veuillez saisir une expression mathématique: ");
            expression = scanner.nextLine();

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

    public void fermerScanner() {
        scanner.close();
    }
}

