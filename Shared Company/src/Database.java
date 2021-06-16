package SharedMobility2;


import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Database
{
    private ArrayList<Utente> listautenti;
    private ArrayList<Veicoli> listaveicoli;
    private ArrayList<Auto> listaAutomobili;
    private ArrayList<Moto> listaMoto;
    private ArrayList<Furgone> listaFurgoni;
    private ArrayList<MonopattinoElett> listaMonopattini;
    private ArrayList<ScooterElettrico> listaScooter;
    private ArrayList<Bicicletta> listaBicicletta;

    public Database(ArrayList<Utente> listautenti, ArrayList<Veicoli> listaveicoli) {
        setListautenti(listautenti);
        setListaveicoli(listaveicoli);
        aggiornaliste(listaveicoli);
    }

    public void aggiornaliste(ArrayList<Veicoli> listaveicoli)
    {
        for (Veicoli veicolo:listaveicoli)
        {
            if (veicolo instanceof Auto) listaAutomobili.add((Auto) veicolo);
            if (veicolo instanceof SharedMobility2.Moto) listaMoto.add((Moto) veicolo);
            if (veicolo instanceof Furgone) listaFurgoni.add((Furgone) veicolo);
            if (veicolo instanceof MonopattinoElett) listaMonopattini.add((MonopattinoElett) veicolo);
            if (veicolo instanceof ScooterElettrico) listaScooter.add((ScooterElettrico) veicolo);
            if (veicolo instanceof Bicicletta) listaBicicletta.add((Bicicletta) veicolo);
        }
    }

    public ArrayList<Utente> getListautenti() {
        return listautenti;
    }

    public void setListautenti(ArrayList<Utente> listautenti) {
        this.listautenti = listautenti;
    }

    public ArrayList<Veicoli> getListaveicoli() {
        return listaveicoli;
    }

    public void setListaveicoli(ArrayList<Veicoli> listaveicoli) {
        this.listaveicoli = listaveicoli;
    }
    public Database(){};

    private double distance(Coordinate posizione1,Coordinate posizione2, char unit)
    {
        double lon1=posizione1.getLongitudine();
        double lat1=posizione1.getLatitudine();
        double lon2=posizione2.getLongitudine();
        double lat2=posizione2.getLatitudine();
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit==('K')) {
            dist = dist * 1.609344;
        } else if (unit==('N')) {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /* The function to convert decimal into radians */
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    /* The function to convert radians into decimal */
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}

