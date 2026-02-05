package utils;

public record ComposantsValeur(Double valeur1, String operateur, Double valeur2) {

    @Override
    public String toString() {
        return valeur1 + " " + operateur + " " + valeur2;
    }
}
