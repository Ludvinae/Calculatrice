package historique;

import java.util.List;

public class CalculDbService {

    private final CalculDAO dao;

    public CalculDbService() {
        BaseDonneeInit.init(); // crée la table si besoin
        dao = new CalculDAOImp();
    }

    public void addCalcul(double valeur1Db, String operateurDb, double valeur2Db, double resultatDb ) {
        dao.insert(new Calcul(valeur1Db, operateurDb, valeur2Db, resultatDb));
    }

    public List<Calcul> getAllCalculs() {
        return dao.findAll();
    }

    public Calcul dernierCalcul() {
        return dao.findLast();
    }

    public void deleteCalcul() {
        dao.deleteAll();
    }
}
