package calcul;

import exception.DivisionParZero;

public class Division implements IMath {


    private double valeur1;
    private double valeur2;

    public Division(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    @Override
    public double calculer() {
        if (valeur2 == 0) throw new DivisionParZero("Impossible de diviser par zéro");
        return valeur1 / valeur2;
    }

    public void setValeur1(double valeur1) {
        this.valeur1 = valeur1;
    }
}
