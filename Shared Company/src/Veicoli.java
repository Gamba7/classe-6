public abstract class  Veicoli {
    private long id=1;
    private double costoalminuto;
    private Stato stato;
    private Carburante carburante;
    private TipoCarburante tipocarburante;
    private String Targa;
    private double latitudine;
    private double longitudine;

    public Patente getPatenterichiesta() {
        return patenterichiesta;
    }

    public void setPatenterichiesta(Patente patenterichiesta) {
        this.patenterichiesta = patenterichiesta;
    }

    private Patente patenterichiesta;


    public Veicoli(double costoalminuto, Stato stato, Carburante carburante, TipoCarburante tipocarburante, String Targa,double latitudine,double longitudine) //AUTO, MOTO, FURGONI
    {
        setId(id);
        id++;
        setCostoalminuto(costoalminuto);
        setStato(stato);
        setCarburante(carburante);
        setTipoCarburante(tipocarburante);
        setTarga(Targa);
        setLatitudine(latitudine);
        setLongitudine(longitudine);
    }

    public Veicoli(double costoalminuto, Stato stato, Carburante carburante, String targa,double latitudine,double longitudine) //SCOOTER MONOPATTINO
    {
        setId(id);
        id++;
        setCostoalminuto(costoalminuto);
        setStato(stato);
        setCarburante(carburante);
        setTarga(targa);
        setLatitudine(latitudine);
        setLongitudine(longitudine);
    }

    public Veicoli(double costoalminuto, Stato stato,double latitudine,double longitudine) //BICICLETTA
    {
        setId(id);
        id++;
        setCostoalminuto(costoalminuto);
        setStato(stato);
        setLatitudine(latitudine);
        setLongitudine(longitudine);
    }
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

    public String getTarga() {
        return Targa;
    }

    public void setTarga(String targa) {
        Targa = targa;
    }



    public double getCostoalminuto() {
        return costoalminuto;
    }

    public void setCostoalminuto(double costoalminuto) {
        this.costoalminuto = costoalminuto;
    }


    public TipoCarburante getTipoCarburante() {
        return tipocarburante;
    }

    public void setTipoCarburante(TipoCarburante tipocarburante)
    {
        this.tipocarburante = tipocarburante;
    }

    public Carburante getCarburante()
    {
        return carburante;
    }

    public void setCarburante(Carburante carburante)
    {
        this.carburante = carburante;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }


    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato)
    {
        this.stato = stato;
    }

}
enum Stato
{
    Disponibile, Occupato;
}

enum Carburante
{
    c100, c70, c50, c30, c0;
}
enum TipoCarburante {BENZINA, ELETTRICO}