package nl.hva.bedrijf;

/**
 * Superclass, bevat alle standaard informatie van een persoon.
 *
 * @author Tim Knops
 */

public class Persoon {

    private String naam;

    /**
     * Constructor.
     *
     * @param naam naam van het persoon
     */
    public Persoon(String naam) {
        this.naam = naam;
    }

    /** Returns de inkomsten van een persoon. */
    public double berekenInkomsten() {
        return 0; // Methode word abstract in week 6.
    }

    /** Returns string waarde van een persoon */
    public String toString() {
        return naam;
    }
}
