public class Bicicletta extends Veicoli{

    public Bicicletta(int id, double costoalminuto, Stato stato,double latitudine, double longitudine) {
        super(costoalminuto, stato,latitudine,longitudine);
        super.setTipoCarburante(null);
        super.setTarga(null);
    }
}