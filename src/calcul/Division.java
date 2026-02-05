package calcul;

import exception.DivisionParZero;

public class Division implements IMath {
    // Division implements IMath et va récupérer ses propriétés et méthods.

    private double valeur1;
    private double valeur2;

    /**
     * Constructeur de la class Division prend pour paramètres les valeur1 et valeur2 en type double.
     * @param : valeur1
     * @param : valeur2
     */

    public Division(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    /**
     * Méthod qui permet de diviser la valeur1 par la valeur2.
     * Si division par 0 remonte l'erreur jusqu'au manager.
     * @return résultat en double.
     */
    @Override
    public double calculer() {
        if (valeur2 == 0) throw new DivisionParZero("Impossible de diviser par zéro");
        return valeur1 / valeur2;
    }

    // Mise en place des Setters pour Tests

    public void setValeur1(double valeur1) {
        this.valeur1 = valeur1;
    }
}
