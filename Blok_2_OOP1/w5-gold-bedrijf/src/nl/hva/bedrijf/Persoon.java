package nl.hva.bedrijf;

public class Persoon {

    private String naam;

    public Persoon(String naam) {
        this.naam = naam;
    }

    public double berekenInkomsten() {
        return 0; // Methode word abstract in week 6.
    }

    public String toString() {
        return naam;
    }
}
