package nl.hva.bedrijf;

/**
 * Sub-class van Persoon, bevat alle informatie van een standaard medewerker.
 *
 * @see Persoon
 * @author Tim Knops
 */

public class Werknemer extends Persoon {

    private static int laatstePersoneelsnummer = 1000;
    private double maandsalaris;
    private int personeelsnummer;

    /**
     * Constructor.
     *
     * @param maandsalaris  hoeveelheid dat een medewerker elke maand betaald krijgt
     * @param naam          naam van de medewerker
     */
    public Werknemer(double maandsalaris, String naam) {
        super(naam);
        this.maandsalaris = maandsalaris;
        this.personeelsnummer = laatstePersoneelsnummer++;
    }

    /** Returns het maandsalaris van de medewerker. */
    public double getMaandsalaris() {
        return maandsalaris;
    }

    /** {@inheritDoc} */
    @Override
    public double berekenInkomsten() {
        return maandsalaris;
    }
}
