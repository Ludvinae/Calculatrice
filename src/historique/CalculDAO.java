package historique;

import java.util.List;
 //interface qui créer un contract d'utilisation pour le DAO
public interface CalculDAO {
    void insertion(Calcul calcul);
    List<Calcul> rechercheTous();
    Calcul rechercheDernier();
    void effacerTout();
}
