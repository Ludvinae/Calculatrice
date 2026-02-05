package calcul;

import exception.DivisionParZero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDivision {

    private Division division;

    @Before
    public void setUp() {
        this.division = new Division(0, 0);
    }

    @Test
    public void testDivisionParZero() {
        // Arrange
        double result;
        division.setValeur1(4);
        //Act
        try {
            result = division.calculer();
            Assert.fail();
        }
        catch (DivisionParZero e) {
            Assert.assertEquals("Impossible de diviser par zéro", e.getMessage());
        }
    }
}
