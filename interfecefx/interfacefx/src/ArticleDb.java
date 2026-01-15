package interfecefx.interfacefx.src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDb {
    // URL de votre base de données PostgreSQL
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
    // Méthode pour créer un article
    public static boolean createArticle(String codeArticle, String libelle, int qte, double prixHT) {
        try {
            int codeArticleInt = Integer.parseInt(codeArticle);  // Convertir le code en entier
            String query = "INSERT INTO Article (CodeArticle, Libelle, Qte, PrixHT) VALUES (?, ?, ?, ?)";

            try (Connection conn = connect(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, codeArticleInt);  // Utilisez setInt pour insérer un entier
                stmt.setString(2, libelle);
                stmt.setInt(3, qte);
                stmt.setDouble(4, prixHT);

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // Retourne true si l'insertion a réussi
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur de conversion du code article en entier : " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'article : " + e.getMessage());
            return false;
        }
    }

    // Méthode pour récupérer tous les articles
    public static List<String> getAllArticles() {
        List<String> articles = new ArrayList<>();
        String query = "SELECT * FROM Article";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String article = "Code: " + rs.getString("CodeArticle") +
                        ", Libellé: " + rs.getString("Libelle") +
                        ", Quantité: " + rs.getInt("Qte") +
                        ", Prix: " + rs.getDouble("PrixHT");
                articles.add(article);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des articles : " + e.getMessage());
        }
        return articles;
    }

    // Méthode pour supprimer un article par son code
    public static boolean deleteArticle(String codeArticle) {
        // Convertir codeArticle en entier
        try {
            int codeArticleInt = Integer.parseInt(codeArticle);  // Convertir le code en entier

            String query = "DELETE FROM Article WHERE CodeArticle = ?";  // Suppression par CodeArticle (entier)

            try (Connection conn = connect(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, codeArticleInt);  // Utiliser le codeArticle en tant qu'entier

                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // Retourner true si l'article a été supprimé
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur de conversion du code article en entier : " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'article : " + e.getMessage());
            return false;
        }
    }

    // Méthode pour mettre à jour un article
    public static boolean updateArticle(String codeArticle, String libelle, int qte, double prixHT) {
        try {
            // Convertir le codeArticle en entier
            int codeArticleInt = Integer.parseInt(codeArticle);  // Convertir en entier
    
            String query = "UPDATE Article SET Libelle = ?, Qte = ?, PrixHT = ? WHERE CodeArticle = ?";
    
            try (Connection conn = connect(); 
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, libelle);
                stmt.setInt(2, qte);
                stmt.setDouble(3, prixHT);
                stmt.setInt(4, codeArticleInt);  // Utiliser le codeArticle converti en entier
    
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // Retourne true si la mise à jour a réussi
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur de conversion du code article en entier : " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'article : " + e.getMessage());
            return false;
        }
    }
    
}