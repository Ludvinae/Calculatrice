package calcul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSoustraction {
    private Soustraction soustraction1;
    private Soustraction soustraction2;
    private Soustraction soustraction3;

    @Before
    public void setUp() {
        this.soustraction1 = new Soustraction(0,1);
        this.soustraction2 = new Soustraction(451.3,102.94);
        this.soustraction3 = new Soustraction(65,-5);
    }

    // Le test 1 vérifie que Substraction gère bien les résultats négatifs
    @Test
    public void testSous1() {
        // Arrange
        double result;
        // Act
        result = soustraction1.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 0 et 1 devrait faire -1", -1, result, 0);
    }

    // Le test 2 vérifie que Substraction gère bien les nombres à virgule
    @Test
    public void testSous2() {
        // Arrange
        double result;
        // Act
        result = soustraction2.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 451.3 et 102.94 devrait faire 348.36", 348.36, result, 0);
    }

    // Le test 3 vérifie que Substraction gère bien la soustraction par un nombre négatif
    @Test
    public void testSous3() {
        // Arrange
        double result;
        // Act
        result = soustraction3.calculer();
        // Assert
        Assert.assertEquals("La soustraction de 65 et -5 devrait faire 70", 70, result, 0);
    }
}
