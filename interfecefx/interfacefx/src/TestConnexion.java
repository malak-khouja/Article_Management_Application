/*package interfecefx.interfacefx.src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {
    public static void main(String[] args) {
        // Informations de connexion
        String url = "jdbc:postgresql://localhost:5432/gestion"; // Remplacez localhost par l'adresse de votre serveur si nécessaire
        String user = "postgres"; // Votre utilisateur PostgreSQL
        String password = "malak"; // Votre mot de passe PostgreSQL

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connexion établie avec succès !");
            } else {
                System.out.println("Connexion échouée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion : " + e.getMessage());
        }
    }
}*/
