package convertisseur;

import calcul.*;
import exception.OperateurInconnu;
import utils.ComposantsValeur;

import java.util.Objects;
    // la class Operation permet de sélection en fonction de l'opérateur la bonne implémentation de calcul
public class Operation {

    private ComposantsValeur input;

        /**
         * Constructeur de la class Operation prend une input en paramètre de type ComposantsValeur
         * @param : input
         */
    public Operation(ComposantsValeur input) {
        this.input = input;
    }

        /**
         * Method qui sélectionne la class implémentée par IMath adéquate pour le calcul
         * @return objet IMath
         */
    protected IMath getOperator() {
        if (Objects.equals(input.operateur(), "+")) return new Addition(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "-")) return new Soustraction(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "*")) return new Multiplication(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "/")) return new Division(input.valeur1(), input.valeur2());
        throw new OperateurInconnu("Il manque un opérateur valide a l'expression entrée.");
    }

        /**
         * Methods qui permet d'obtenir un résultat en fonction de l'opération choisi par getOperator
         * @return resultat en double
         */
    public double getResult()  {
        IMath calcul = getOperator();
        return calcul.calculer();
    }
}
