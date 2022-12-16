package nl.hva.huisdierenverzorger;

public class Main {
    public static void main(String[] args) {
        huisdierenVerzorgen();
        equalsDemonstratie();
    }

    /**
     * Demonstreren van .equals methode in Kat
     */
    private static void equalsDemonstratie() {
        Kat kat = new Kat("Pim", "Birmaan", 10);
        Kat teVergelijken = new Kat("James Bond", "Zomerkat", 10);
        Kat meerTeVergelijken = new Kat("Hulk", "Winterkat");

        System.out.printf("Is kat hetzelfde %b%n", kat.equals(teVergelijken));
        System.out.printf("Is kat hetzelfde %b%n", kat.equals(meerTeVergelijken));
    }

    /**
     * Voeg dieren toe, laat ze acties uitvoeren!
     */
    private static void huisdierenVerzorgen() {
        Huisdierenverzorger huisdierenverzorger = new Huisdierenverzorger();

        //voeg 3 honden toe
        huisdierenverzorger.voegHuisdierToe(new Hond("Freddy", true));
        huisdierenverzorger.voegHuisdierToe(new Hond("Mo", false));
        huisdierenverzorger.voegHuisdierToe(new Hond("Hans", true));

        //voeg 3 katten toe
        huisdierenverzorger.voegHuisdierToe(new Kat("Frederick", "Britse korthaar", 12));
        huisdierenverzorger.voegHuisdierToe(new Kat("Dier", "Lentekat", 9));
        huisdierenverzorger.voegHuisdierToe(new Kat("Lisa", "Koudwater"));

        //voeg 3 hamsters toe
        huisdierenverzorger.voegHuisdierToe(new Hamster("Hagrid", true));
        huisdierenverzorger.voegHuisdierToe(new Hamster("Kars", true));
        huisdierenverzorger.voegHuisdierToe(new Hamster("Redouane", false));

        System.out.println("---- Alle dieren geluid");
        huisdierenverzorger.laatAlleDierenGeluidMaken();
        System.out.println("---- Hamsters knagen");
        huisdierenverzorger.laatHamstersKnagen();
        System.out.println("---- Gevaarlijke honden");
        huisdierenverzorger.printGevaarlijkeHonden();
        System.out.println("----");

    }
}
