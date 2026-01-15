package interfecefx.interfacefx.src;
import java.util.Date;

public class Commande implements Opération{
    private String NumCmd;
    private Date DateCmd;
    private double TotalHT;
    private double TotalTTC;
    @SuppressWarnings("unused")
    private Client client;

    public Commande(String numCmd, Date dateCmd, double totalHT, double totalTTC, Client client) {
        this.NumCmd = numCmd;
        this.DateCmd = dateCmd;
        this.TotalHT = totalHT;
        this.TotalTTC = totalTTC;
        this.client = client;
    }

    public void setNumCmd(String numCmd) {
        this.NumCmd = numCmd;
    }

    public String getNumCmd() {
        return NumCmd;
    }

    public void setDateCmd(Date dateCmd) {
        this.DateCmd = dateCmd;
    }

    public Date getDateCmd() {
        return DateCmd;
    }

    public void setTotalHT(double totalHT) {
        this.TotalHT = totalHT;
    }

    public double getTotalHT() {
        return TotalHT;
    }

    public void setTotalTTC(double totalTTC) {
        this.TotalTTC = totalTTC;
    }

    public double getTotalTTC() {
        return TotalTTC;
    }

    public void Affiche_Commande(String CodeClient){
        System.out.println("Commande Numéro : "+NumCmd);
        System.out.println("Date de la commande : "+DateCmd);
        System.out.println("Total HT : "+TotalHT+"\n");
    }

    @override //la sous classe commande implemente la methode commande a la superclasse operation c'est pourquoi on doit ajputer @override
    public void Commander (Date dateCd, String codeArticle, int qte){
        System.out.println("commande effectuée le  : "+dateCd);
        System.out.println("code de l'article : "+codeArticle);
        System.out.println("quantité commandé : "+qte+"\n");

    }

    @override // de meme pour prix commande
    public void Prix_Commande (double prixTTC, String prixLettre){
        System.out.println("Total du prix TTC : "+TotalTTC);
        System.out.println("prix TTC en Lettre : "+prixLettre+"\n");
        
    }
}
