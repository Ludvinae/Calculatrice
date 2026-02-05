package calcul;

import exception.DivisionParZero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Dictionary;

public class TestDivision {

    private Division division1;
    private Division division2;
    private Division division3;
    private Division division4;
    private Division division5;

    @Before
    public void setUp() {
        this.division1 = new Division(4, 0);
        this.division2 = new Division(16, 4);
        this.division3 = new Division(-10, 2);
        this.division4 = new Division(20, 8);
        this.division5 = new Division(24.6,5.24);
    }

    // Le test 1 vérifie que l'erreur de la division par zéro est bien traitée
    @Test
    public void testDivisionParZero() {
        // Arrange
        double result;
        //Act
        try {
            result = division1.calculer();
            Assert.fail();
        }
        catch (DivisionParZero e) {
            Assert.assertEquals("Impossible de diviser par zéro", e.getMessage());
        }
    }

    // Le test 2 vérifie que Division gère bien la division d'entiers divisibles
    @Test
    public void testDivisionEntiersPositifs() {
        // Arrange
        double result;
        // Act
        result = division2.calculer();
        // Assert
        Assert.assertEquals("La division de 16 et 4 devrait faire 4",4,result,0);
    }

    // Le test 3 vérifie que Division gère bien la division d'entiers négatifs divisibles
    @Test
    public void testDivisionEntiersNégatifs() {
        // Arrange
        double result;
        // Act
        result = division3.calculer();
        // Assert
        Assert.assertEquals("La division de -10 et 2 devrait faire -5",-5,result,0);
    }

    // Le test 4 vérifie que Division gère bien la division d'entiers non divisibles
    @Test
    public void testDivisionResultatFlottant() {
        // Arrange
        double result;
        // Act
        result = division4.calculer();
        // Assert
        Assert.assertEquals("La division de 20 et 8 devrait faire 2.5",2.5,result,0);
    }

    // Le test 5 vérifie que Division gère bien la division de nombres flottants
    @Test
    public void testDivisionFlottant() {
        // Arrange
        double result;
        // Act
        result = division5.calculer();
        // Assert
        Assert.assertEquals("La division de 24.6 et 5.24 devrait faire 4.6946564885496183206106870229008", 4.6946564885496183206106870229008,result,0.001);
    }
}
