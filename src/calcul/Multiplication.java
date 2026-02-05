package calcul;

public class Multiplication implements IMath{


    private double valeur1;
    private double valeur2;

    public Multiplication(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    @Override
    public double calculer() {
        return valeur1 * valeur2;
    }
}
