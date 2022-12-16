package nl.hva.huisdierenverzorger;

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
    public boolean equals(Object andereKat) {
        if (andereKat instanceof Kat) {
            Kat kat = (Kat) andereKat;
            return this.aantalLevens == kat.aantalLevens;
        }

        return false;

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
