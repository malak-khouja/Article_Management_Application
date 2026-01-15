package interfecefx.interfacefx.src;
import java.util.Date;

interface Opération {
    public void Commander(Date dateCd, String codeArticle, int qte);
    public void Prix_Commande(double prixTTC, String prixLettre);
}