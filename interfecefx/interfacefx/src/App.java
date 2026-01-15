package interfecefx.interfacefx.src;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        showMainMenu(primaryStage);
    }

    private void showMainMenu(Stage stage) {
        // Création du layout principal
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Bienvenue dans la gestion des articles");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button createButton = createStyledButton("Créer un article");
        Button updateButton = createStyledButton("Mettre à jour un article");
        Button deleteButton = createStyledButton("Effacer un article");
        Button readButton = createStyledButton("Voir tous les articles");

        createButton.setOnAction(e -> showCreateArticlePage(stage));
        updateButton.setOnAction(e -> showUpdateArticlePage(stage));
        deleteButton.setOnAction(e -> showDeleteArticlePage(stage));
        readButton.setOnAction(e -> showAllArticlesPage(stage));

        root.getChildren().addAll(welcomeLabel, createButton, updateButton, deleteButton, readButton);

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Menu Principal");
        stage.show();
    }
    // Création du layout de la creation de l'article
    private void showCreateArticlePage(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Créer un nouvel article");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField codeField = new TextField();
        codeField.setPromptText("Code Article");

        TextField libelleField = new TextField();
        libelleField.setPromptText("Libellé");

        TextField qteField = new TextField();
        qteField.setPromptText("Quantité");

        TextField prixField = new TextField();
        prixField.setPromptText("Prix HT");

        // Ajout d'un label pour les messages d'erreur
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");

        Button saveButton = createStyledButton("Enregistrer");
        saveButton.setOnAction(e -> {
            try {
                boolean success = ArticleDb.createArticle(codeField.getText(), libelleField.getText(),
                        Integer.parseInt(qteField.getText()), Double.parseDouble(prixField.getText()));
                if (success) {
                    showConfirmationPage(stage, "Article ajouté avec succès !");
                    errorLabel.setText("");  // Effacer le message d'erreur si la création est réussie
                } else {
                    errorLabel.setText("Erreur lors de l'ajout de l'article.");
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Vérifiez les champs ! Assurez-vous que la quantité et le prix sont des nombres valides.");
            }
        });

        Button backButton = createStyledButton("Retour");
        backButton.setOnAction(e -> showMainMenu(stage));

        root.getChildren().addAll(titleLabel, codeField, libelleField, qteField, prixField, saveButton, backButton, errorLabel);
        stage.setScene(new Scene(root, 500, 400));
    }
    // Création du layout de mise a jour
    private void showUpdateArticlePage(Stage stage) {
        Stage updateStage = new Stage();
        updateStage.setTitle("Mise à jour de l'article");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        TextField codeField = new TextField();
        codeField.setPromptText("Code de l'article");

        TextField libelleField = new TextField();
        libelleField.setPromptText("Libellé");

        TextField qteField = new TextField();
        qteField.setPromptText("Quantité");

        TextField prixField = new TextField();
        prixField.setPromptText("Prix HT");

        // Ajout du label d'erreur
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");

        Button saveButton = createStyledButton("Mettre à jour");
        Button cancelButton = createStyledButton("Annuler");

        saveButton.setOnAction(e -> {
            try {
                boolean success = ArticleDb.updateArticle(codeField.getText(), libelleField.getText(),
                        Integer.parseInt(qteField.getText()), Double.parseDouble(prixField.getText()));
                if (success) {
                    showConfirmationPage(updateStage, "Article mis à jour avec succès !");
                    errorLabel.setText("");  // Effacer le message d'erreur si la mise à jour est réussie
                } else {
                    errorLabel.setText("Erreur lors de la mise à jour de l'article.");
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Vérifiez les champs ! Assurez-vous que la quantité et le prix sont des nombres valides.");
            }
        });

        cancelButton.setOnAction(e -> updateStage.close());

        vbox.getChildren().addAll(new Label("Code de l'article"), codeField, new Label("Libellé"), libelleField,
                new Label("Quantité"), qteField, new Label("Prix HT"), prixField, saveButton, cancelButton, errorLabel);

        Scene updateScene = new Scene(vbox, 400, 300);
        updateStage.setScene(updateScene);
        updateStage.show();
    }
    // Création du layout de supression
    private void showDeleteArticlePage(Stage stage) {
        Stage deleteStage = new Stage();
        deleteStage.setTitle("Suppression de l'article");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        TextField codeField = new TextField();
        codeField.setPromptText("Code de l'article");

        // Ajout du label d'erreur
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");

        Button deleteButton = createStyledButton("Supprimer");
        Button cancelButton = createStyledButton("Annuler");

        deleteButton.setOnAction(e -> {
            boolean success = ArticleDb.deleteArticle(codeField.getText());
            if (success) {
                showConfirmationPage(deleteStage, "Article supprimé avec succès !");
                errorLabel.setText("");  // Effacer le message d'erreur si la suppression est réussie
            } else {
                errorLabel.setText("Erreur lors de la suppression de l'article.");
            }
        });

        cancelButton.setOnAction(e -> deleteStage.close());

        vbox.getChildren().addAll(new Label("Code de l'article"), codeField, deleteButton, cancelButton, errorLabel);

        Scene deleteScene = new Scene(vbox, 400, 300);
        deleteStage.setScene(deleteScene);
        deleteStage.show();
    }

// Création du layout d'affiche des articles
    private void showAllArticlesPage(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
    
        Label titleLabel = new Label("Tous les articles");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    
        // Création de la ListView pour afficher les articles
        ListView<String> articlesListView = new ListView<>();
        List<String> articles = ArticleDb.getAllArticles();
    
        // Remplir la ListView avec les articles
        articlesListView.getItems().addAll(articles);
    
        // Ajout de la possibilité de défiler si la liste est trop longue
        articlesListView.setPrefHeight(300);
    
        // Ajout d'un champ de recherche pour filtrer les articles
        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher un article...");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            articlesListView.getItems().clear();
            for (String article : articles) {
                if (article.toLowerCase().contains(newValue.toLowerCase())) {
                    articlesListView.getItems().add(article);
                }
            }
        });
    
        Button backButton = createStyledButton("Retour");
        backButton.setOnAction(e -> showMainMenu(stage));
    
        // Ajouter les composants dans le VBox
        root.getChildren().addAll(titleLabel, searchField, articlesListView, backButton);
        stage.setScene(new Scene(root, 500, 400));
    }

    private void showConfirmationPage(Stage stage, String message) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label confirmationLabel = new Label(message);
        Button menuButton = createStyledButton("Retour");
        menuButton.setOnAction(e -> showMainMenu(stage));

        root.getChildren().addAll(confirmationLabel, menuButton);
        stage.setScene(new Scene(root, 500, 400));
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-color: #9B4D96; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 10px;");
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}