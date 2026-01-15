package interfecefx.interfacefx.src;
import java.util.Date;

public class Article {
    private String CodeArticle;
    private String Libelle;
    private double Qte;
    private double PrixHT;

    public Article(String CodeArticle, String Libelle, double Qte, double PrixHT) {
        this.CodeArticle = CodeArticle;
        this.Libelle = Libelle;
        this.Qte = Qte;
        this.PrixHT = PrixHT;
    }

    public void setCodeArticle(String codeArticle) {
        this.CodeArticle = codeArticle;
    }
    public String getCodeArticle() {
        return CodeArticle;
    }

    public void setLibelle(String libelle) {
        this.Libelle = libelle;
    }
    public String getLibelle() {
        return Libelle;
    }

    public void setPrixHT(double prixHT) {
        this.PrixHT = prixHT;
    }
    public double getPrixHT() {
        return PrixHT;
    }

    public void setQte(double qte) {
        this.Qte = qte;
    }
    public double getQte() {
        return Qte;
    }

    public void Affiche_Article(String CodeClient, Date DateCmd){
        System.out.println("Client : " + CodeClient);
        System.out.println("Date : " + DateCmd);
        System.out.println("Article : " + CodeArticle);
        System.out.println("Libelle : " + Libelle);
        System.out.println("Qte : " + Qte);
        System.out.println("Prix HT : " + PrixHT+"\n");
    }
}
