package nl.hva.huisdier;

public class Hamster extends Huisdier {

    private boolean isTam;

    public Hamster(String naam, boolean isTam) {
        super(naam);
        this.isTam = isTam;
    }

    public void knagen() {
        System.out.printf("Mijn naam is %s%n", super.naam);

        if (isTam) {
            System.out.println("Ik knaag alleen eten");
        } else {
            System.out.println("Ik knaag de kooi stuk");
        }
    }
}
