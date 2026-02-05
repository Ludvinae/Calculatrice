package calcul;

public class Addition implements IMath{
    // addition implements IMath et va récupérer ses propriétés et méthods.
    private double valeur1;
    private double valeur2;

    /**
     * Constructeur de la class Addition prend pour paramètres les valeur1 et valeur2 en type double.
     * @param : valeur1
     * @param : valeur2
     */
    public Addition(double valeur1, double valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    /**
     * Méthod qui permet d'additionner la valeur1 à la valeur2.
     * @return résultat en double.
     */
    @Override
    public double calculer() {
        return valeur1 + valeur2;
    }

}
