import convertisseur.Interpreteur;
import convertisseur.Operation;
import exception.DivisionParZero;
import exception.OperateurInconnu;
import historique.*;
import scanner.Scanner;
import sortie.Affichage;
import ui.Vue;
import utils.ComposantsString;
import utils.ComposantsValeur;

import java.util.List;

// La class Manager sert de contrôleur pour la calculatrice et va gérer le programme dans son ensemble.
public class Manager {

    private Scanner scanner;
    private CalculDbService serviceDB;

    public Manager() {
        scanner = new Scanner();
        gestionDB();
        Vue vue = new Vue();
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
     * Method Interpret va permettre d'interpréter l'expression donnée par l'utilisateur.
     * @return ComposantValeur
     */
    private ComposantsValeur interprete() {
        String ex = getExpression();
        Interpreteur interprete = new Interpreteur(ex);
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
    private void appelAffichage(double result, ComposantsValeur composant) {
        Affichage display = new Affichage(result, composant);
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

    public void effacerHistorique() {
        serviceDB.deleteCalcul();
    }

    /**
     * Method calculatrice est le point d'entrée du programme.
     */
    public void calculatrice() {

        ComposantsValeur composant = interprete();

        try {
            double result = appelCalculer(composant);
            appelAffichage(result, composant);
            serviceDB.addCalcul(composant.valeur1(), composant.operateur(), composant.valeur2(), result);
        }
        catch(DivisionParZero | OperateurInconnu e) {
            System.out.println(e.getMessage());
        }
    }

}
