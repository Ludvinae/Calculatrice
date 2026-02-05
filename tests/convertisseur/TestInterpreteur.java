package convertisseur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ComposantsString;
import utils.ComposantsValeur;

public class TestInterpreteur {
    private Interpreteur interpreteur1;
    private Interpreteur interpreteur2;
    private Interpreteur interpreteur3;
    private Interpreteur interpreteur4;
    private Interpreteur interpreteur5;

    @Before
    public void setUp() {
        this.interpreteur1 = new Interpreteur("4-50");
        this.interpreteur2 = new Interpreteur("6+-8");
        this.interpreteur3 = new Interpreteur("4.5*6.25");
        this.interpreteur4 = new Interpreteur("-4/50");
        this.interpreteur5 = new Interpreteur("82--3.5");
    }

    // Test sur la méthode separerElement()

    // Le test 1 vérifie que Interpreteru sépare bien l'expression en trois
    @Test
    public void testSeparerElement1() {
        // Arrange
        ComposantsString result;
        // Act
        result = interpreteur1.separerComposants();
        // Assert
        Assert.assertEquals("L'expression devrait être séparée en trois: 4, -, 50", new ComposantsString("4","-","50"), result);
    }

    // Le test 2 vérifie que Interpreteru sépare bien l'expression en trois, avec le deuxième nombre négatif
    @Test
    public void testSeparerElement2() {
        // Arrange
        ComposantsString result;
        // Act
        result = interpreteur2.separerComposants();
        // Assert
        Assert.assertEquals("L'expression devrait être séparée en trois: 6, +, -8", new ComposantsString("6","+","-8"), result);
    }

    // Le test 3 vérifie que Interpreteru sépare bien l'expression en trois, avec des nombres flottants
    @Test
    public void testSeparerElement3() {
        // Arrange
        ComposantsString result;
        // Act
        result = interpreteur3.separerComposants();
        // Assert
        Assert.assertEquals("L'expression devrait être séparée en trois: 4.5, *, 6.25", new ComposantsString("4.5","*","6.25"), result);
    }

    // Le test 4 vérifie que Interpreteru sépare bien l'expression en trois, avec le premier nombre négatif
    @Test
    public void testSeparerElement4() {
        // Arrange
        ComposantsString result;
        // Act
        result = interpreteur4.separerComposants();
        // Assert
        Assert.assertEquals("L'expression devrait être séparée en trois: -4, /, 50", new ComposantsString("-4","/","50"), result);
    }

    // Le test 5 vérifie que Interpreteru sépare bien l'expression en trois, avec le deuxième nombre négatif et une soustraction
    @Test
    public void testSeparerElement5() {
        // Arrange
        ComposantsString result;
        // Act
        result = interpreteur5.separerComposants();
        // Assert
        Assert.assertEquals("L'expression devrait être séparée en trois: 82, -, -3.5", new ComposantsString("82","-","-3.5"), result);
    }

    // Test sur la méthode genererFormule()

    // Le test vérifie que Interpreteur transforme bien les trois composants de l'expression en ComposantsValeur
    @Test
    public void testGenererFormule() {
        // Arrange
        ComposantsString parametre;
        ComposantsValeur result;
        // Act
        parametre = interpreteur1.separerComposants();
        result = interpreteur1.genererFormule(parametre);
        // Assert
        Assert.assertEquals("Le ComposantsString devrait être transformé en ComposantsValeur(4d,'-',50d)", new ComposantsValeur(4d, "-", 50d), result);
    }
}
