package utils;
    //Le record stocke valeur1, operateur, et valeur2 dans un objet immuable.
public record ComposantsValeur(Double valeur1, String operateur, Double valeur2) {

        /**
         * Permet d'afficher la bonne mise en forme du contenu de ComposantValeur.
         * @return String
         */
    @Override
    public String toString() {
        return valeur1 + " " + operateur + " " + valeur2;
    }
}
