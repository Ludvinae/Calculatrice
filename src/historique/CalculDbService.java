package historique;

import java.util.List;

// Class qui va permettre de centraliser toutes les classes du package historique pour être utilisé à l'extérieur.
public class CalculDbService {

    private final CalculDAO dao;

    /**
     * Méthod qui permet d'initialiser la base de donnée.
     */
    public CalculDbService() {
        BaseDonneeInit.init(); // crée la table si besoin
        dao = new CalculDAOImp();
    }

    /**
     * Méthod qui appelle le dao pour ajouter un calcul en base de donnée.
     * @param : valeur1Db
     * @param : operateurDb
     * @param : valeur2Db
     * @param : resultatDb
     */
    public void ajoutCalcul(double valeur1Db, String operateurDb, double valeur2Db, double resultatDb ) {
        dao.insertion(new Calcul(valeur1Db, operateurDb, valeur2Db, resultatDb));
    }

    /**
     * Méthods qui appelle le dao pour récupérer la liste des entrées en base de donnée.
     * @return List<Cacul>
     */
    public List<Calcul> tousLesCalculs() {
        return dao.rechercheTous();
    }

    /**
     * Méthod qui appelle le dao pour récupérer la dernière entrée mise en base de donnée.
     * @return calcul
     */
    public Calcul dernierCalcul() {
        return dao.rechercheDernier();
    }

    /**
     * Méthod qui appelle le dao pour effacer toutes les entrées mise en base de donnée.
     */
    public void effacerCalculs() {
        dao.effacerTout();
    }
}
