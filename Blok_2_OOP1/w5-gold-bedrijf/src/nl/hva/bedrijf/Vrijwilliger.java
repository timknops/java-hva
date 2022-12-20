package nl.hva.bedrijf;

public class Vrijwilliger extends Persoon {

    public Vrijwilliger(String naam) {
        super(naam);
    }

    public void huurIn(int uren) {
        // Gaat in week 6 via de interface.
    }

    @Override
    public double berekenInkomsten() {
        return 0; // Inkomsten zijn er niet.
    }
}
