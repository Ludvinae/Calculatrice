import convertisseur.Interpreteur;
import convertisseur.Operation;
import exception.DivisionParZero;
import exception.OperateurInconnu;
import scanner.Scanner;
import sortie.Affichage;
import utils.ComposantsString;
import utils.ComposantsValeur;
// La class Manager sert de contrôleur pour la calculatrice et va gérer le programme dans son ensemble.
public class Manager {

    private Scanner scanner;

    public Manager() {
        scanner = new Scanner();
    }

    /**
     * Method getExpression va permettre de récupérer l'expression de l'utilisateur
     * @return String expression
     */
    public String getExpression() {
        String expression = scanner.demanderExpression();
        scanner.fermerScanner();

        return expression;
    }

    /**
     * Method Interpret va permettre d'interpréter l'expression donnée par l'utilisateur.
     * @return ComposantValeur
     */
    public ComposantsValeur interpret() {
        String ex = getExpression();
        Interpreteur interpret = new Interpreteur(ex);
        ComposantsString composants = interpret.separerComposants();
        return interpret.genererFormule(composants);
    }

    /**
     * Method appelCalculer va appeler la method operation et sélectionner la bonne formule mathématique.
     * @param : composant
     * @return resultat en double
     */
    public double appelCalculer(ComposantsValeur composant) {
        Operation operation = new Operation(composant);
        return operation.getResult();
    }

    /**
     * Method appelAffichage va permettre d'afficher de l'expression et le résultat à l'utilisateur.
     * @param : result
     * @param : composant
     */
    public void appelAffichage(double result, ComposantsValeur composant) {
        Affichage display = new Affichage(result, composant);
        display.afficher();
    }

    /**
     * Method calculatrice est le point d'entrée du programme.
     */
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
