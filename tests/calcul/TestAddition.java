package calcul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAddition {

    private Addition addition;


    @Before
    public void setUp() {
        this.addition = new Addition(0, 0);
    }

    @Test
    public void testAdd() {
        // Arrange
        addition.setValeur1(5);
        double result;
        // Act
        result = addition.calculer();
        // Assert
        Assert.assertEquals("Addition de 2 et 3 devrait faire 5", 5, result, 0);
    }




}
