package calcul;

public class Addition implements IMath{

    private double valeur1;
    private double valeur2;

    public Addition(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    @Override
    public double calculer() {
        return valeur1 + valeur2;
    }

    // pour test

    public void setValeur1(double valeur1) {
        this.valeur1 = valeur1;
    }

    public void setValeur2(double valeur2) {
        this.valeur2 = valeur2;
    }
}
