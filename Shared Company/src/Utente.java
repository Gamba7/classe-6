import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;



public class Utente
{
    private String nome;
    private String cognome;
    private String data_nascita;
    private String codice_fiscale;
    private int credito_carta;
    private boolean maggiorenne;
    private Patente[] patente;
    private boolean casco;
    private double latitudine;
    private double longitudine;

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }



    public boolean isMaggiorenne() {
        return maggiorenne;
    }

    public void setMaggiorenne(boolean maggiorenne) {
        this.maggiorenne = maggiorenne;
    }

    public Patente[] getPatente() {
        return patente;
    }

    public void setPatente(Patente[] patente) {
        this.patente = patente;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getData_nascita() { return data_nascita; }
    public void setData_nascita(String data_nascita) { this.data_nascita = data_nascita; }
    public String getCodice_fiscale() { return codice_fiscale; }
    public void setCodice_fiscale(String codice_fiscale) { this.codice_fiscale = codice_fiscale; }
    public int getCredito_carta() { return credito_carta; }
    public void setCredito_carta(int credito_carta) { this.credito_carta = credito_carta; }

    public Utente (String nome, String cognome, String codice_fiscale,String data_nascita, Patente[] patente, boolean casco,double latitudine,double longitudine)
    {
        setNome(nome);
        setCognome(cognome);
        setData_nascita(data_nascita);
        setCodice_fiscale(codice_fiscale);
        setCredito_carta(0);
        setMaggiorenne(controlloeta());
        setPatente(patente);
        setCasco(casco);
        setLatitudine(latitudine);
        setLongitudine(longitudine);

    }

    public boolean controlloeta ()
            {
            Date d = null;
            //si procura la data sotto forma di una stringa nel formato SHORT
                //converte la stringa della data in un oggetto di classe Date
            try{
                DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                //imposta che i calcoli di conversione della data siano rigorosi
                formatoData.setLenient(false);
                d = formatoData.parse(getData_nascita());
            } catch (ParseException e) {
                System.out.println("Formato data non valido.");
            }
            //visualizza la data non formattata (sfruttando implicitamente il metodo toString dell'oggetto)
            Date c = new Date();
            int x = c.getYear();
            int y = d.getYear();
            if ((x-y)>=18) return true;
            return false;
            }

    public static void main(String[] args) {
        Utente io = new Utente("Giuseppe","Di Giovannantonio","DDDD","02/09/1993", new Patente[]{Patente.PATENTEA, Patente.PATENTEB1},true,35.86,98.66);
    }
    }

    enum Patente {PATENTEA, PATENTEB1, PATENTEB2}


