package calcul;

public class Multiplication implements IMath{
    // Mutiplication implements IMath et va récupérer ses propriétés et méthods.
    private double valeur1;
    private double valeur2;

    /**
     * Constructeur de la class Multiplication prend pour paramètres les valeur1 et valeur2 en type double.
     * @param : valeur1
     * @param : valeur2
     */
    public Multiplication(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    /**
     * Méthod qui permet de multiplier la valeur1 avec la valeur2.
     * @return résultat en double.
     */
    @Override
    public double calculer() {
        return valeur1 * valeur2;
    }

}
