import javax.xml.crypto.Data;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Database
{
    private List<Automobili> listaAutomobili;
    private List<Moto> listaMoto;
    private List<Furgoni> listaFurgoni;
    private List<Monopattino> listaMonopattino;
    private List<Scooter> listaScooter;
    private List<Bicicletta> listaBicicletta;
    private List<Utente> listaUtenti;
    private List<Veicoli> listaveicoli;


    public Database(List<Veicoli> listaveicoli,List<Utente> listaUtenti)
    {
        aggiornaliste(listaveicoli);
        setListaUtenti(listaUtenti);
    }


    public void aggiornaliste(List<Veicoli> listaveicoli)
    {
        for (Veicoli veicolo:listaveicoli)
        {
            if (veicolo instanceof Automobili) listaAutomobili.add((Automobili) veicolo);
            if (veicolo instanceof Moto) listaMoto.add((Moto) veicolo);
            if (veicolo instanceof Furgoni) listaFurgoni.add((Furgoni) veicolo);
            if (veicolo instanceof Monopattino) listaMonopattino.add((Monopattino) veicolo);
            if (veicolo instanceof Scooter) listaScooter.add((Scooter) veicolo);
            if (veicolo instanceof Bicicletta) listaBicicletta.add((Bicicletta) veicolo);
        }
    }
    public void ordinaperdistanza(Utente utente)
    {
        double min=2000;
        int index=0;
        for(int k=0;k<listaveicoli.size();k++)
        {
            for (int i = (0+k); i < listaveicoli.size(); i++)
            {
                double distanza = 6372.795477598 * Math.acos((Math.sin(utente.getLatitudine())) * Math.sin(listaveicoli.get(i).getLatitudine()) + Math.cos(utente.getLatitudine())) * Math.cos(listaveicoli.get(i).getLatitudine()) * Math.cos(utente.getLongitudine()) - Math.cos(listaveicoli.get(i).getLongitudine());
                if (distanza < min)
                {
                    min = distanza;
                    index = i;
                }
            }
            listaveicoli.add(listaveicoli.get(k));
            listaveicoli.set(k,listaveicoli.get(index));
            listaveicoli.set(listaveicoli.size(), listaveicoli.get(index));
            listaveicoli.remove(listaveicoli.size());

        }
    }
    public boolean checkpatente(Patente patenterichiesta,Patente[] patentiutente)
    {

        for (Patente patente:patentiutente)
        {
            if (patenterichiesta.equals(patente)) return true;
        }
        return false;
    }

    public void stampadisponibili(Utente utente)
    {
        ordinaperdistanza(utente);
        for (Veicoli veicolo:listaveicoli)
        {
            if((checkpatente(veicolo.getPatenterichiesta(),utente.getPatente()))&&(veicolo.getStato().equals(Stato.Disponibile)))
            {
                System.out.println(veicolo.getId()+" "+veicolo.getTarga()+" "+veicolo.getCostoalminuto());
            }
        }
    }

    public static void main(String[] args) {
        Automobili punto = new Automobili(5,Stato.Disponibile,Carburante.c100,TipoCarburante.BENZINA,"PUNTO",45.12,66.33);
       Moto honda= new Moto(5,Stato.Disponibile,Carburante.c100,TipoCarburante.BENZINA,"virgola",48.12,100.33);
        Utente io =new Utente("io","sempreio","DGVSONOIO","02/09/2000", new Patente[]{Patente.PATENTEA, Patente.PATENTEB1},true,68.12,99.45);
       List<Veicoli> lista;
        lista = {punto;honda}
        lista.add(punto);
       lista.add(honda);
       List<Utente> listautente=null;
       listautente.add(io);
        Database database = new Database(lista,listautente);
        database.stampadisponibili(io);




    }





    public List<Automobili> getListaAutomobili() {
        return listaAutomobili;
    }

    public void setListaAutomobili(List<Automobili> listaAutomobili) {
        this.listaAutomobili = listaAutomobili;
    }

    public List<Moto> getListaMoto() {
        return listaMoto;
    }

    public void setListaMoto(List<Moto> listaMoto) {
        this.listaMoto = listaMoto;
    }

    public List<Furgoni> getListaFurgoni() {
        return listaFurgoni;
    }

    public void setListaFurgoni(List<Furgoni> listaFurgoni) {
        this.listaFurgoni = listaFurgoni;
    }

    public List<Monopattino> getListaMonopattino() {
        return listaMonopattino;
    }

    public void setListaMonopattino(List<Monopattino> listaMonopattino) {
        this.listaMonopattino = listaMonopattino;
    }

    public List<Scooter> getListaScooter() {
        return listaScooter;
    }

    public void setListaScooter(List<Scooter> listaScooter) {
        this.listaScooter = listaScooter;
    }

    public List<Bicicletta> getListaBicicletta() {
        return listaBicicletta;
    }

    public void setListaBicicletta(List<Bicicletta> listaBicicletta) {
        this.listaBicicletta = listaBicicletta;
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}
