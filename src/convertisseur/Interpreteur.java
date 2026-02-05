package convertisseur;

import calcul.Addition;
import utils.ComposantsString;
import utils.ComposantsValeur;
import utils.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreteur {

    private String expression;

    public Interpreteur(String expression) {
        this.expression = expression;
    }

    public ComposantsString separerComposants() {
        String regex = Regex.getPattern();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(expression);
        // Commande indispensable pour que les groupes fonctionnent wtf
        m.matches();
        ComposantsString c;
        try {
            c = new ComposantsString(m.group(1), m.group(2), m.group(3));
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            c = null;
        }
        return c;
    }

    public ComposantsValeur genererFormule(ComposantsString composant) {
        Double valeur1 = Double.parseDouble(composant.valeur1());
        Double valeur2 = Double.parseDouble(composant.valeur2());
        String operateur = composant.operateur();

        return new ComposantsValeur(valeur1, operateur, valeur2);
    }




}
