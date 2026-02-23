package historique;

// Class qui va servir de référence à l'entrée du tableau en base de donnée.
public class Calcul {
    private int id;
    private double valeur1Db;
    private String operateurDb;
    private double valeur2Db;
    private double resultatDb;

    /**
     * Constructeur de l'Objet Calcul avec id.
     * @param : id
     * @param : valeur1Db
     * @param : operateurDb
     * @param : valeur2Db
     * @param : resultatDb
     */
    public Calcul(int id, double valeur1Db, String operateurDb, double valeur2Db, double resultatDb) {
        this.id = id;
        this.valeur1Db = valeur1Db;
        this.operateurDb = operateurDb;
        this.valeur2Db = valeur2Db;
        this.resultatDb = resultatDb;
    }

    /**
     * Constructeur de l'objet Calcul sans l'id.
     * @param : valeur1Db
     * @param : operateurDb
     * @param : valeur2Db
     * @param : resultatDb
     */
    public Calcul(double valeur1Db, String operateurDb, double valeur2Db, double resultatDb) {
        this.valeur1Db = valeur1Db;
        this.operateurDb = operateurDb;
        this.valeur2Db = valeur2Db;
        this.resultatDb = resultatDb;
    }

    // getter et setter des paramètres de l'objet Calcul.
    public double getResultatDb() {
        return resultatDb;
    }
    public void setResultatDb(double resultatDb) {
        this.resultatDb = resultatDb;
    }

    public double getValeur2Db() {
        return valeur2Db;
    }
    public void setValeur2Db(double valeur2Db) {
        this.valeur2Db = valeur2Db;
    }

    public String getOperateurDb() {
        return operateurDb;
    }
    public void setOperateurDb(String operateurDb) {
        this.operateurDb = operateurDb;
    }

    public double getValeur1Db() {
        return valeur1Db;
    }
    public void setValeur1Db(double valeur1Db) {
        this.valeur1Db = valeur1Db;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
