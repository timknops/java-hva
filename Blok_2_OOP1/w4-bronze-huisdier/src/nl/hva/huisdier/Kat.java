package nl.hva.huisdier;

public class Kat extends Huisdier {

    private static final int STANDAARD_AANTAL_LEVENS = 9;
    private String ras;
    private int aantalLevens;

    public Kat(String naam, String ras, int aantalLevens) {
        super(naam);
        this.ras = ras;
        this.aantalLevens = aantalLevens;
    }

    public Kat(String naam, String ras) {
        this(naam, ras, STANDAARD_AANTAL_LEVENS);
    }

    @Override
    public void maakGeluid() {
        System.out.printf("%s doet: Miauwwwwwwwww%n", this.naam);
    }

    @Override
    public String toString() {
        return "Kat{" +
                "naam=" + super.naam +
                ", ras='" + ras + '\'' +
                ", aantalLevens=" + aantalLevens +
                '}';
    }
}
