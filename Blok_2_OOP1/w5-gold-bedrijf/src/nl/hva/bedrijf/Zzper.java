package nl.hva.bedrijf;

import java.util.Currency;

public class Zzper extends Persoon {

    private double uurtarief;
    private int uurGewerkt;

    public Zzper(double uurtarief, String naam) {
        super(naam);
        this.uurtarief = uurtarief;
    }

    public void huurIn(int uren) {
        // Gaat in week 6 via de interface.
    }

    @Override
    public double berekenInkomsten() {
        return uurtarief * uurGewerkt;
    }
}
