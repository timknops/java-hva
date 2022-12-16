package nl.hva.huisdierenverzorger;

public class Huisdier {

    protected String naam;

    public Huisdier(String naam) {
        this.naam = naam;
    }

    public void maakGeluid() {
        System.out.println("Maakt nog even geen geluid");
    }
}
