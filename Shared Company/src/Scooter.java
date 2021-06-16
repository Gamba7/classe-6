public class Scooter  extends Veicoli
{


    public Scooter(double costoalminuto, Stato stato,double latitudine, double longitudine) {
        super(costoalminuto, stato,latitudine,longitudine);
        super.setTipoCarburante(TipoCarburante.ELETTRICO);
        super.setTarga(null);
    }
}