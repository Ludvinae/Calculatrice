package sortie;

import utils.ComposantsValeur;

import java.text.DecimalFormat;

public class Affichage {

    private double result;
    private double valeur1;
    private double valeur2;
    private String operateur;

    public Affichage(double result, ComposantsValeur expression) {
        this.result = result;
        this.valeur1 = expression.valeur1();
        this.valeur2 = expression.valeur2();
        this.operateur = expression.operateur();
    }

    public void afficher() {
        DecimalFormat df = new DecimalFormat();
        String expression = df.format(valeur1) + " " + operateur + " " + df.format(valeur2) + " = ";
        System.out.println(expression + df.format(result));
    }



}
