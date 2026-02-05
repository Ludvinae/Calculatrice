package calcul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSubstraction {
    private Substraction substraction1;
    private Substraction substraction2;
    private Substraction substraction3;

    @Before
    public void setUp() {
        this.substraction1 = new Substraction(0,1);
        this.substraction2 = new Substraction(451.3,102.94);
        this.substraction3 = new Substraction(65,-5);
    }

    // Le test 1 vérifie que Substraction gère bien les résultats négatifs
    @Test
    public void testSous1() {
        // Arrange
        double result;
        // Act
        result = substraction1.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 0 et 1 devrait faire -1", -1, result, 0);
    }

    // Le test 2 vérifie que Substraction gère bien les nombres à virgule
    @Test
    public void testSous2() {
        // Arrange
        double result;
        // Act
        result = substraction2.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 451.3 et 102.94 devrait faire 348.36", 348.36, result, 0);
    }

    // Le test 3 vérifie que Substraction gère bien la soustraction par un nombre négatif
    @Test
    public void testSous3() {
        // Arrange
        double result;
        // Act
        result = substraction3.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 65 et -5 devrait faire 70", 70, result, 0);
    }
}
