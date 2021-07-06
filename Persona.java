import java.util.Set;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String indirizzo;
    private Set<String> figli;

    public Persona(String nome, String cognome, int eta, String codiceFiscale, String indirizzo,Set<String> figli) {
        setNome(nome);
        setCognome(cognome);
        setEta(eta);
        setCodiceFiscale(codiceFiscale);
        setIndirizzo(indirizzo);
        setFigli(figli);
    }

    public Set<String> getFigli() {
        return figli;
    }

    public void setFigli(Set<String> figli) {
        this.figli = figli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


}
