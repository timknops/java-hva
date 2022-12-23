package nl.hva.bedrijf;

/**
 * Sub-Class van Persoon. Heeft de mogelijkheid om ingehuurd te worden voor een bepaalde hoeveelheid tijd en heeft
 * geen inkomsten.
 *
 * @see Persoon
 * @author Tim Knops
 */

public class Vrijwilliger extends Persoon {

    /**
     * Constructor.
     *
     * @param naam  naam van de medewerker
     */
    public Vrijwilliger(String naam) {
        super(naam);
    }

    public void huurIn(int uren) {
        // Gaat in week 6 via de interface.
    }

    /** {@inheritDoc} */
    @Override
    public double berekenInkomsten() {
        return 0; // Inkomsten zijn er niet.
    }
}
