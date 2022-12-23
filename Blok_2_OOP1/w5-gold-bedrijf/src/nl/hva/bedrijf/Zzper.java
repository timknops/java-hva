package nl.hva.bedrijf;

/**
 * Sub-Class van Persoon, heeft als toevoeging een uurtarief en kan ingehuurd worden.
 *
 * @see Persoon
 * @author Tim Knops
 */

public class Zzper extends Persoon {

    private double uurtarief;
    private int uurGewerkt;

    /**
     * Constructor
     *
     * @param uurtarief  hoeveelheid dat de Zzp'er per uur betaald krijgt
     * @param naam       naam van de zzp'er
     */
    public Zzper(double uurtarief, String naam) {
        super(naam);
        this.uurtarief = uurtarief;
    }

    public void huurIn(int uren) {
        // Gaat in week 6 via de interface.
    }

    /** {@inheritDoc} */
    @Override
    public double berekenInkomsten() {
        return uurtarief * uurGewerkt;
    }
}
