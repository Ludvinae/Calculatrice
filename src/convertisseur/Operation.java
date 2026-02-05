package convertisseur;

import calcul.*;
import exception.OperateurInconnu;
import utils.ComposantsValeur;

import java.util.Objects;


public class Operation {

    private ComposantsValeur input;

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
