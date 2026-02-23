package historique;

import java.util.List;

public interface CalculDAO {
    void insertion(Calcul calcul);
    List<Calcul> rechercheTous();
    Calcul rechercheDernier();
    void effacerTout();
}
