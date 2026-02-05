package scanner;

import exception.AlaisException;
import exception.FormatIncorrect;
import exception.OperateurInconnu;
import exception.ValeurNonNumerique;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestVerifierExpression {

    public String expression;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testOperateurInconnu1() throws OperateurInconnu {
        expression = "32";
        expectedException.expect(OperateurInconnu.class);
        expectedException.expectMessage("Il manque un opéraeur valide a l'expression entrée.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testOperateurInconnu2() throws OperateurInconnu {
        expression = "2 % 8";
        expectedException.expect(OperateurInconnu.class);
        expectedException.expectMessage("Il manque un opéraeur valide a l'expression entrée.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testVirgule1() throws AlaisException {
        expression = "2,9 / 3";
        expectedException.expect(AlaisException.class);
        expectedException.expectMessage("Veuillez utiliser un point à la place de la virgule pour séparer les décimales.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testVirgule2() throws AlaisException {
        expression = "8.1 - 2,8";
        expectedException.expect(AlaisException.class);
        expectedException.expectMessage("Veuillez utiliser un point à la place de la virgule pour séparer les décimales.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testValeurNonNumeriques1() throws ValeurNonNumerique {
        expression = "fkjezh*fjhez";
        expectedException.expect(ValeurNonNumerique.class);
        expectedException.expectMessage("L'expression doit contenir uniquement des valeurs numériques et l'opérateur.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testValeurNonNumeriques2() throws ValeurNonNumerique {
        expression = "33 + 55e";
        expectedException.expect(ValeurNonNumerique.class);
        expectedException.expectMessage("L'expression doit contenir uniquement des valeurs numériques et l'opérateur.");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testFormatIncorrect1() throws FormatIncorrect {
        expression = "3+3+1";
        expectedException.expect(FormatIncorrect.class);
        expectedException.expectMessage("Le format de l'expression devrait suivre le format 'valeur opérateur valeur");
        VerifierExpression.verifierExpression(expression);
    }

    @Test
    public void testFormatIncorrect2() throws FormatIncorrect {
        expression = "3 * 888.1-";
        expectedException.expect(FormatIncorrect.class);
        expectedException.expectMessage("Le format de l'expression devrait suivre le format 'valeur opérateur valeur");
        VerifierExpression.verifierExpression(expression);
    }

}
