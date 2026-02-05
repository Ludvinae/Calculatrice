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

    public IMath getOperator() {
        if (Objects.equals(input.operateur(), "+")) return new Addition(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "-")) return new Substraction(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "*")) return new Multiplication(input.valeur1(), input.valeur2());
        if (Objects.equals(input.operateur(), "/")) return new Division(input.valeur1(), input.valeur2());
        throw new OperateurInconnu("Veuillez utiliser +, -, * ou /");
    }

    public double getResult()  {
        IMath calcul = getOperator();
        return calcul.calculer();
    }
}
