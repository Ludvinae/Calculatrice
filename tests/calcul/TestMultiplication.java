package calcul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMultiplication {
    private Multiplication multiplication1;
    private Multiplication multiplication2;
    private Multiplication multiplication3;
    private Multiplication multiplication4;

    @Before
    public void setUp() {
        this.multiplication1 = new Multiplication(2,3);
        this.multiplication2 = new Multiplication(-2,3);
        this.multiplication3 = new Multiplication(-2,-3);
        this.multiplication4 = new Multiplication(2.5,4.1);
    }

    // Le test 1 vérifie que Multiplication gère bien la multiplication d'entiers
    @Test
    public void testMul1() {
        // Arrange
        double result;
        // Act
        result = multiplication1.calculer();
        // Assert
        Assert.assertEquals("Multiplication de 2 et 3 devrait faire 6", 6, result, 0);
    }

    // Le test 2 vérifie que Multiplication gère bien la multiplication d'entiers dont un négatif
    @Test
    public void testMul2() {
        // Arrange
        double result;
        // Act
        result = multiplication2.calculer();
        // Assert
        Assert.assertEquals("Multiplication de -2 et 3 devrait faire -6", -6, result, 0);
    }

    // Le test 3 vérifie que Multiplication gère bien la multiplication d'entiers négatifs
    @Test
    public void testMul3() {
        // Arrange
        double result;
        // Act
        result = multiplication1.calculer();
        // Assert
        Assert.assertEquals("Multiplication de -2 et -3 devrait faire 6", 6, result, 0);
    }

    // Le test 4 vérifie que Multiplication gère bien la multiplication de flottants
    @Test
    public void testMul4() {
        // Arrange
        double result;
        // Act
        result = multiplication4.calculer();
        // Assert
        Assert.assertEquals("Multiplication de 2.5 et 4.1 devrait faire 10.25", 10.25, result, 0);
    }
}
