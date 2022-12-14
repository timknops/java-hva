package nl.hva.registratiesysteem;

public class Docent extends Persoon {

    public Docent(String naam, String woonplaats) {
        super(naam, woonplaats);
    }

    public boolean krijgtReiskostenvergoeding() {
        return !woonplaats.equals("Amsterdam");
    }

    public String toString() {
        String reiskostenVergoeding = krijgtReiskostenvergoeding() ? "krijgt reiskosten" : "krijgt geen reiskosten";

        return String.format("Docent %s uit %s, %s\n",
                this.naam, this.woonplaats, reiskostenVergoeding);
    }
}
