import convertisseur.Interpreteur;
import convertisseur.Operation;
import exception.DivisionParZero;
import exception.OperateurInconnu;
import scanner.Scanner;
import sortie.Affichage;
import utils.ComposantsString;
import utils.ComposantsValeur;

public class Manager {

    private Scanner scanner;

    public Manager() {
        scanner = new Scanner();
    }

    public String getExpression() {
        String expression = scanner.demanderExpression();
        scanner.fermerScanner();

        return expression;
    }

    public ComposantsValeur interpret() {
        String ex = getExpression();
        Interpreteur interpret = new Interpreteur(ex);
        ComposantsString composants = interpret.separerComposants();
        return interpret.genererFormule(composants);
    }

    public double appelCalculer(ComposantsValeur composant) {
        Operation operation = new Operation(composant);
        return operation.getResult();
    }

    public void appelAffichage(double result, ComposantsValeur composant) {
        Affichage display = new Affichage(result, composant);
        display.afficher();
    }

    public void calculatrice() {
        ComposantsValeur composant = interpret();

        try {
            double result = appelCalculer(composant);
            appelAffichage(result, composant);
        }
        catch(DivisionParZero | OperateurInconnu e) {
            System.out.println(e.getMessage());
        }
    }

}
