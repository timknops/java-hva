package nl.hva.bedrijf;

public class Werknemer extends Persoon {

    private static int laatstePersoneelsnummer = 1000;
    private double maandsalaris;
    private int personeelsnummer;

    public Werknemer(double maandsalaris, String naam) {
        super(naam);
        this.maandsalaris = maandsalaris;
        this.personeelsnummer = laatstePersoneelsnummer++;
    }

    public double getMaandsalaris() {
        return maandsalaris;
    }

    @Override
    public double berekenInkomsten() {
        return maandsalaris;
    }
}
