package interfecefx.interfacefx.src;
public class Client {
    private String CodeClient;
    private String Rs;
    private String Adresse;
    private String telephone;

    public Client(String codeClient, String Rs, String adresse, String telephone) {
        this.CodeClient = codeClient;
        this.Rs = Rs;
        this.Adresse = adresse;
        this.telephone = telephone;
    }

    public void setCodeClient(String codeClient) {
        this.CodeClient = codeClient;
    }
    public String getCodeClient() {
        return CodeClient;
    }

    public void setRs(String Rs) {
        this.Rs = Rs;
    }
    public String getRs() {
        return Rs;
    }

    public void setAdresse(String adresse) {
        this.Adresse = adresse;
    }
    public String getAdresse() {
        return Adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getTelephone() {
        return telephone;
    }
}

