package historique;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculDAOImp implements CalculDAO{

    private final String url = "jdbc:sqlite:calcul.db";

    @Override
    public void insert(Calcul calcul) {
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

    @Override
    public List<Calcul> findAll() {
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

    public Calcul findLast() {
        String sql = "SELECT * FROM calculs ORDER BY id DESC LIMIT 1";
        Calcul calcul = null;

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                calcul = new Calcul(
                        rs.getInt("id"),
                        rs.getInt("valeur1Db"),
                        rs.getString("operateurDb"),
                        rs.getInt("valeur2Db"),
                        rs.getInt("resultatDb")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calcul;
    }


    @Override
    public void deleteAll() {
        String sql = "DELETE FROM calculs";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
