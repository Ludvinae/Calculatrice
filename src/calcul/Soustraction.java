package calcul;

public class Soustraction implements IMath{
    // Substraction implements IMath et va récupérer ses propriétés et méthods.
    private double valeur1;
    private double valeur2;

    /**
     * Constructeur de la class Soustraction prend pour paramètres les valeur1 et valeur2 en type double.
     * @param : valeur1
     * @param : valeur2
     */
    public Soustraction(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }
    /**
     * Méthod qui permet de soustraire la valeur2 à la valeur1.
     * @return résultat en double.
     */
    @Override
    public double calculer() {
        return valeur1 - valeur2;
    }
}
