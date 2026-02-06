package convertisseur;

import calcul.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ComposantsValeur;

import static org.junit.Assert.assertTrue;

public class TestOperation {
    private Operation operation1;
    private Operation operation2;
    private Operation operation3;
    private Operation operation4;

    @Before
    public void setUp() {
        this.operation1 = new Operation(new ComposantsValeur(1d, "+", 2d));
        this.operation2 = new Operation(new ComposantsValeur(1d, "-", 2d));
        this.operation3 = new Operation(new ComposantsValeur(1d, "*", 2d));
        this.operation4 = new Operation(new ComposantsValeur(1d, "/", 2d));
    }

    // Test sur la méthode getOperateur()

    // Le test 1 vérifie que Operation renvoie bien un objet Addition pour une addition
    @Test
    public void testGetOperateur1() {
        // Arrange
        IMath result;
        // Act
        result = operation1.getOperateur();
        // Assert
        assertTrue(result instanceof Addition);
    }

    // Le test 2 vérifie que Operation renvoie bien un objet Soustraction pour une soustraction
    @Test
    public void testGetOperateur2() {
        // Arrange
        IMath result;
        // Act
        result = operation2.getOperateur();
        // Assert
        assertTrue(result instanceof Soustraction);
    }

    // Le test 3 vérifie que Operation renvoie bien un objet Multiplication pour une multiplication
    @Test
    public void testGetOperateur3() {
        // Arrange
        IMath result;
        // Act
        result = operation3.getOperateur();
        // Assert
        assertTrue(result instanceof Multiplication);
    }

    // Le test 4 vérifie que Operation renvoie bien un objet Division pour une division
    @Test
    public void testGetOperateur4() {
        // Arrange
        IMath result;
        // Act
        result = operation4.getOperateur();
        // Assert
        assertTrue(result instanceof Division);
    }

    // Test sur la méthode getResult()

    // Le test 1 vérifie que Operation renvoie bien le résultat attendu pour une addition
    @Test
    public void testGetResult1() {
        // Arrange
        double result;
        // Act
        result = operation1.getResultat();
        // Assert
        Assert.assertEquals("Devrait renvoyer l'addition de 1 et 2 donc 3", 3, result, 0);
    }

    // Le test 2 vérifie que Operation renvoie bien le résultat attendu pour une soustraction
    @Test
    public void testGetResult2() {
        // Arrange
        double result;
        // Act
        result = operation2.getResultat();
        // Assert
        Assert.assertEquals("Devrait renvoyer la soustraction de 1 et 2 donc -1", -1, result, 0);
    }

    // Le test 3 vérifie que Operation renvoie bien le résultat attendu pour une multiplication
    @Test
    public void testGetResult3() {
        // Arrange
        double result;
        // Act
        result = operation3.getResultat();
        // Assert
        Assert.assertEquals("Devrait renvoyer la multiplication de 1 et 2 donc 2", 2, result, 0);
    }

    // Le test 4 vérifie que Operation renvoie bien le résultat pour une division
    @Test
    public void testGetResult4() {
        // Arrange
        double result;
        // Act
        result = operation4.getResultat();
        // Assert
        Assert.assertEquals("Devrait renvoyer la division de 1 et 2 donc 0.5", 0.5, result, 0);
    }
}
