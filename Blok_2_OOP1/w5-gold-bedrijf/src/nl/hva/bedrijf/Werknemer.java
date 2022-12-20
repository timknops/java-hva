package nl.hva.bedrijf;

public class Werknemer extends Persoon {

    private static int laatstePersoneelsnummer = 1000;
    private double maandSalaris;
    private int personeelsnummer;

    public Werknemer(double maandSalaris, String naam) {
        super(naam);
        this.maandSalaris = maandSalaris;
        this.personeelsnummer = laatstePersoneelsnummer++;
    }

    @Override
    public double berekenInkomsten() {
        return 0; // Inkomsten zijn er niet.
    }
}
