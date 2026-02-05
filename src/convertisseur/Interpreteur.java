package convertisseur;

import utils.ComposantsString;
import utils.ComposantsValeur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
    // la class Interpreteur va permettre d'interpréter l'expression et la convertir en formule Mathématique
public class Interpreteur {

    private String expression;

        /**
         * Constructeur de la class Interpreteur prend une expression en paramètre de type String
         * @param : expression
         */
    public Interpreteur(String expression) {
        this.expression = expression;
    }

        /**
         * Methods qui permet de séparer les différents composants de l'expression en trois groupes
         * @return Constructeur pour le record ComposantsString
         */
    public ComposantsString separerComposants() {
        String regex = "^\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(expression);
        // Commande indispensable pour que les groupes fonctionnent
        m.matches();
        ComposantsString c;
        try {
            c = new ComposantsString(m.group(1), m.group(2), m.group(3));
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            System.out.println("Impossible de séparer l'expression en trois composants.");
            c = null;
        }
        return c;
    }

        /**
         * Methods qui va permettre de générer la formule mathématique prend en paramètre un objet ComposantsString
         * @param : composant
         * @return constructeur pour le record ComposantsValeur
         */
    public ComposantsValeur genererFormule(ComposantsString composant) {
        Double valeur1 = Double.parseDouble(composant.valeur1());
        Double valeur2 = Double.parseDouble(composant.valeur2());
        String operateur = composant.operateur();

        return new ComposantsValeur(valeur1, operateur, valeur2);
    }




}
