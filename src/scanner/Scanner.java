package scanner;

import exception.FormatIncorrect;
import exception.ValeurNonNumerique;

import static scanner.VerifierExpression.verifierExpression;
import static scanner.VerifierExpression.verifierValeurNumeriques;

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
                if (!verifierValeurNumeriques(expression)) {
                    throw new ValeurNonNumerique("Veuillez entrer des nombres et des operateurs uniquement");

                }

            }
            catch (ValeurNonNumerique e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                if (!verifierExpression(expression)) {
                    throw new FormatIncorrect("Le format doit suivre le schéma 'nombre opérateur nombre'");
                }
                break;
            } catch (FormatIncorrect e) {
                System.out.println(e.getMessage());
            }
        }

        return expression;
    }

    public void fermerScanner() {
        scanner.close();
    }
}

