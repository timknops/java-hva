package nl.hva.bedrijf;

import java.util.ArrayList;

/**
 * De klasse Bedrijf bevat de bedrijfsnaam en een arraylist met alle medewerkers.
 *
 * @author Tim Knops
 */

public class Bedrijf {

    private String naam;
    private ArrayList<Persoon> medewerkers = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param naam naam van het bedrijf
     */
    public Bedrijf(String naam) {
        this.naam = naam;
    }

    /** Print een lijst van medewerkers met daarbij hun inkomsten. */
    public void printInkomsten() {
        StringBuilder sb = new StringBuilder();

        sb.append("Inkomsten van alle personen:\n");

        for (Persoon medewerker : medewerkers) {
            sb.append(String.format("\t\t%s, inkomsten: %.1f\n",
                    medewerker, medewerker.berekenInkomsten()));
        }

        System.out.println(sb);
    }

    /** Returns het aantal managers van het bedrijf. */
    public int aantalManagers() {
        int counter = 0;

        for (Persoon medewerker : medewerkers) {
            if (medewerker instanceof Manager) {
                counter++;
            }
        }

        return counter;
    }

    /** Voegt een persoon toe aan de medewerkers arraylist */
    public void neemInDienst(Persoon persoon) {
        medewerkers.add(persoon);
    }

    /** Returns string waarde van het bedrijf. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Bedrijf %s heeft %d medewerkers:\n", naam, medewerkers.size()));

        for (Persoon medewerker : medewerkers) {
            sb.append("\t\t").append(medewerker).append("\n");
        }

        return sb.toString();
    }
}
