package historique;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDonneeInit {

    public static void init() {
        String sql = """
                CREATE TABLE IF NOT EXISTS calculs (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                valeur1Db DECIMAL, 
                operateurDb VARCHAR(1),
                valeur2Db DECIMAL, 
                resultatDb DECIMAL);
                """;
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:calcul.db");
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}