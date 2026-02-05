package calcul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAddition {

    private Addition addition1;
    private Addition addition2;
    private Addition addition3;
    private Addition addition4;


    @Before
    public void setUp() {
        this.addition1 = new Addition(2, 3);
        this.addition2 = new Addition(-2,5);
        this.addition3 = new Addition(-5,-5);
        this.addition4 = new Addition(2.5,6.82);
    }

    // Le test 1 vérifie que Addition gère bien l'addition d'entiers
    @Test
    public void testAdd1() {
        // Arrange
        double result;
        // Act
        result = addition1.calculer();
        // Assert
        Assert.assertEquals("Addition de 2 et 3 devrait faire 5", 5, result, 0);
    }

    // Le test 2 vérifie que Addition gère bien l'addition d'entiers négatifs
    @Test
    public void testAdd2() {
        // Arrange
        double result;
        // Act
        result = addition2.calculer();
        // Assert
        Assert.assertEquals("Addition de -2 et 5 devrait faire 3", 3, result, 0);
    }

    // Le test 3 vérifie que Addition gère bien l'addition d'entiers négatifs avec résultat négatif
    @Test
    public void testAdd3() {
        // Arrange
        double result;
        // Act
        result = addition3.calculer();
        // Assert
        Assert.assertEquals("Addition de -5 et -5 devrait faire -10", -10, result, 0);
    }

    // Le test 4 vérifie que Addition gère bien l'addition de flottants
    @Test
    public void testAdd4() {
        // Arrange
        double result;
        // Act
        result = addition4.calculer();
        // Assert
        Assert.assertEquals("Addition de 2.5 et 6.82 devrait faire 9.32", 9.32, result, 0);
    }
}
