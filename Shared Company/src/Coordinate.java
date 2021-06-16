package SharedMobility2;

public class Coordinate
{
    private double latitudine;
    private double longitudine;

    public Coordinate(double latitudine, double longitudine) {
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
}
