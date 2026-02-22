package historique;

import java.util.List;

public class CalculDbService {

    private final CalculDAO dao;

    public CalculDbService(CalculDAO dao) {
        this.dao = dao;
    }

    public void CreationHistorique() {
        BaseDonneeInit.init();
        CalculDAO dao = new CalculDAOImp();
        CalculDbService  serviceDB = new CalculDbService(dao);
    }

    public void addCalcul(double valeur1Db, String operateurDb, double valeur2Db, double resultatDb ) {
        dao.insert(new Calcul(valeur1Db, operateurDb, valeur2Db, resultatDb));
    }

    public List<Calcul> getAllCalculs() {
        return dao.findAll();
    }


    public void deleteCalcul() {
        dao.deleteAll();
    }
}
