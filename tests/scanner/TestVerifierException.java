package scanner;

import exception.OperateurInconnu;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestVerifierException {

    public String expression;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testOperateurInconnu() throws OperateurInconnu {
        // Arrange
        expression = "32";
        expectedException.expect(OperateurInconnu.class);
        expectedException.expectMessage("");
        VerifierExpression.verifierOperateur(expression);
    }
}
