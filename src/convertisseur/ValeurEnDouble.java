package convertisseur;
    // La classe ValeurEnDouble sert à convertir valeur d'un String à un Double.
public class ValeurEnDouble {

    private Double valeur;

        /**
         * Methods qui convertit un String en Double
         * @param : valeur
         */
    public ValeurEnDouble(String valeur) {
        this.valeur = (Double.parseDouble(valeur));
    }
}
