package sortie;

import utils.ComposantsValeur;

import java.text.DecimalFormat;
    // La class Affichage permet d'afficher le résultat dans la console avec la bonne mise en forme.
public class Affichage {

    private double resultat;
    private double valeur1;
    private double valeur2;
    private String operateur;

        /**
         * Constructeur de la class Affichage prend un double resultat et un ComposantsValeur expression en paramètre.
         * @param : result
         * @param : expression
         */
    public Affichage(double resultat, ComposantsValeur expression) {
        this.resultat = resultat;
        this.valeur1 = expression.valeur1();
        this.valeur2 = expression.valeur2();
        this.operateur = expression.operateur();
    }

        /**
         * Methods afficher va afficher dans la console le résultat avec la bonne mise en forme.
         */
    public void afficher() {
        DecimalFormat df = new DecimalFormat();
        String expression = df.format(valeur1) + " " + operateur + " " + df.format(valeur2) + " = ";
        System.out.println(expression + df.format(resultat));
    }



}
