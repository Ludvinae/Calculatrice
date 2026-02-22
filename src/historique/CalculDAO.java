package historique;

import java.util.List;

public interface CalculDAO {
    void insert(Calcul calcul);
    List<Calcul> findAll();
    public Calcul findLast();
    void deleteAll();
}
