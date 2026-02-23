package historique;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe qui va implementer CalculDAO et va servir à stocker toutes les requêtes SQL et faire le lien avec la base de donnée.

public class CalculDAOImp implements CalculDAO{

    private final String url = "jdbc:sqlite:calcul.db";

    /**
     * Méthod qui permet d'insérer une nouvelle donnée dans la base de donnée.
     * @param : calcul
     */
    @Override
    public void insertion(Calcul calcul) {
        String sql = "INSERT INTO calculs(valeur1Db, operateurDb, valeur2Db, resultatDb) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, calcul.getValeur1Db());
            pstmt.setString(2, calcul.getOperateurDb());
            pstmt.setDouble(3, calcul.getValeur2Db());
            pstmt.setDouble(4, calcul.getResultatDb());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthod qui va permettre de récupérer toutes les données inscrites dans la base de donnée.
     * @return : Liste<Calcul>
     */
    @Override
    public List<Calcul> rechercheTous() {
        String sql = "SELECT * FROM calculs";
        List<Calcul> calculs = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                calculs.add(new Calcul(
                        rs.getInt("id"),
                        rs.getDouble("valeur1Db"),
                        rs.getString("operateurDb"),
                        rs.getDouble("valeur2Db"),
                        rs.getDouble("resultatDb")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calculs;
    }

    /**
     * Méthod qui permet de récupérer la dernière entrée mise en base de donnée.
     * @return un objet Calcul
     */
    @Override
    public Calcul rechercheDernier() {
        String sql = "SELECT * FROM calculs ORDER BY id DESC LIMIT 1";
        Calcul calcul = null;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                calcul = new Calcul(
                        rs.getInt("id"),
                        rs.getDouble("valeur1Db"),
                        rs.getString("operateurDb"),
                        rs.getDouble("valeur2Db"),
                        rs.getDouble("resultatDb")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calcul;
    }

    /**
     * Méthod qui va effacer toute l'entrée de la base de donnée.
     */

    @Override
    public void effacerTout() {
        String sql = "DELETE FROM calculs";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
