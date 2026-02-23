package historique;

import java.util.List;

public class CalculDbService {

    private final CalculDAO dao;

    public CalculDbService() {
        BaseDonneeInit.init(); // crée la table si besoin
        dao = new CalculDAOImp();
    }

    public void ajoutCalcul(double valeur1Db, String operateurDb, double valeur2Db, double resultatDb ) {
        dao.insertion(new Calcul(valeur1Db, operateurDb, valeur2Db, resultatDb));
    }

    public List<Calcul> tousLesCalculs() {
        return dao.rechercheTous();
    }

    public Calcul dernierCalcul() {
        return dao.rechercheDernier();
    }

    public void effacerCalculs() {
        dao.effacerTout();
    }
}
