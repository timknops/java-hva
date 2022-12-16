package nl.hva.huisdierenverzorger;

public class Hond extends Huisdier {

    private boolean isGevaarlijk;

    public Hond(String naam, boolean isGevaarlijk) {
        super(naam);
        this.isGevaarlijk = isGevaarlijk;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public void maakGeluid() {
        System.out.println("WOEF");
    }

    public boolean isGevaarlijk() {
        return isGevaarlijk;
    }
}
