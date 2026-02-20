import historique.BaseDonneeInit;
import historique.CalculDAO;
import historique.CalculDAOImp;
import historique.CalculDbService;

public class Main {
    public static void main(String[] args) {

        // new Manager().calculatrice();
        BaseDonneeInit.init(); // crée la table si besoin

        CalculDAO dao = new CalculDAOImp();
        CalculDbService service = new CalculDbService(dao);

        service.addCalcul(1,"+", 2, 3);
        service.addCalcul(8, "*", 3, 24);

        service.getAllCalculs().forEach(calcul ->
                System.out.println(calcul.getValeur1Db() + calcul.getOperateurDb() + calcul.getValeur2Db()+ " ="+ calcul.getResultatDb())
        );


    }
}