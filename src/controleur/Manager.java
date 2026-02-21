package controleur;

import convertisseur.Interpreteur;
import convertisseur.Operation;
import exception.*;
import historique.*;
import scanner.Scanner;
import sortie.Affichage;
import ui.ControleurUI;
import ui.Vue;
import utils.ComposantsString;
import utils.ComposantsValeur;

import java.text.DecimalFormat;
import java.util.List;

import static scanner.VerifierExpression.verifierExpression;

// La class controleur.Manager sert de contrôleur pour la calculatrice et va gérer le programme dans son ensemble.
public class Manager {

    private Scanner scanner;
    private CalculDbService serviceDB;

    public Manager() {
        scanner = new Scanner();
        gestionDB();
    }

    /**
     * Method getExpression va permettre de récupérer l'expression de l'utilisateur
     * @return String expression
     */
    private String getExpression() {
        String expression = scanner.demanderExpression();
        scanner.fermerScanner();

        return expression;
    }

    /**
     * Methode interprete va permettre d'interpréter l'expression donnée par l'utilisateur.
     * @return ComposantValeur
     */
    private ComposantsValeur interprete(String expression) {
        Interpreteur interprete = new Interpreteur(expression);
        ComposantsString composants = interprete.separerComposants();
        return interprete.genererFormule(composants);
    }

    /**
     * Method appelCalculer va appeler la method operation et sélectionner la bonne formule mathématique.
     * @param : composant
     * @return resultat en double
     */
    private double appelCalculer(ComposantsValeur composant) {
        Operation operation = new Operation(composant);
        return operation.getResultat();
    }

    /**
     * Method appelAffichage va permettre d'afficher de l'expression et le résultat à l'utilisateur.
     * @param : result
     * @param : composant
     */
    private void appelAffichage(double resultat, ComposantsValeur composant) {
        Affichage display = new Affichage(resultat, composant);
        display.afficher();
    }

    private void gestionDB() {
        BaseDonneeInit.init(); // crée la table si besoin

        CalculDAO dao = new CalculDAOImp();
        serviceDB = new CalculDbService(dao);
    }

    public List<Calcul> getCalculs() {
        return serviceDB.getAllCalculs();
    }

    public Calcul dernierCalcul() {
        return null;
    }

    public void effacerHistorique() {
        serviceDB.deleteCalcul();
    }

    /**
     * Method calculatrice est le point d'entrée du programme.
     */
    public void calculatrice() {
        String ex = getExpression();
        ComposantsValeur composant = interprete(ex);

        try {
            double resultat = appelCalculer(composant);
            appelAffichage(resultat, composant);
            serviceDB.addCalcul(composant.valeur1(), composant.operateur(), composant.valeur2(), resultat);
        }
        catch(DivisionParZero | OperateurInconnu e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculatriceUI() {
        Vue vue = new Vue(this);
        new ControleurUI(vue, this);
    }

    public String faireCalculUI(String expression) {
        // utilisation de la méthode statique de VerifierExpression pour forcer le test de l'entrée utilsateur venant de l'ui
        try {
            verifierExpression(expression);
            ComposantsValeur composant = interprete(expression);
            double resultat = appelCalculer(composant);
            serviceDB.addCalcul(composant.valeur1(), composant.operateur(), composant.valeur2(), resultat);
            return formatResultat(resultat);
        }
        catch (OperateurInconnu | AlaisException | ValeurNonNumerique | FormatIncorrect | DivisionParZero e){
            return e.getMessage();
        }
    }

    public String formatResultat(double value) {
        DecimalFormat df = new DecimalFormat("0.########");
        return df.format(value);
    }
}
