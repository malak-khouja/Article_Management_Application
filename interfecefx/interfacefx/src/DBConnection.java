/*package interfecefx.interfacefx.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/gestion"; // URL de votre base de données
    private static final String USER = "postgres"; // Utilisateur PostgreSQL
    private static final String PASSWORD = "malak"; // Mot de passe PostgreSQL

    // Méthode pour se connecter à la base de données
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Méthode pour fermer la connexion
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
*/