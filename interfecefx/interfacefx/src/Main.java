package interfecefx.interfacefx.src;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Création des objets
        Client client1 = new Client("C001", "Client 1", "123 rue ABC", "0123456789");
        Commande commande1 = new Commande("C001", new Date(), 15.200, 18.088, client1);
        Article article1 = new Article("A123", "Stouch", 15.0, 45000.0);
        
        // Affichage des informations
        System.out.println("client 1 :\n\tcode : " +client1.getCodeClient() + "\n\tRs : " + client1.getRs() + "\n\tadresse : " + client1.getAdresse() + "\n\ttelephone : " + client1.getTelephone()+"\n");
        System.out.println("commande 1 :\n\tnumcmd : "+commande1.getNumCmd() + "\n\tdatecmd : " + commande1.getDateCmd() + "\n\ttotalHT : " + commande1.getTotalHT() + "\n\ttotalTTC " + commande1.getTotalTTC()+"\n");
        System.out.println("article 1 :\n\tcode : "+article1.getCodeArticle() + "\n\tlibelle : " + article1.getLibelle() + "\n\tquantité : " + article1.getQte() + "\n\tprixHT : " + article1.getPrixHT()+"\n");

        // Display commands and articles for the client
        commande1.Affiche_Commande("C001");
        article1.Affiche_Article("A123", commande1.getDateCmd()); 

        // Appel de la méthode Commander pour passer une commande
        commande1.Commander(new Date(), "A123", 5);

        // Appel de la méthode Prix_Commande pour afficher le prix TTC et en lettres
        commande1.Prix_Commande(120.00, "cent vingt euros");
    }
    
}