package nl.hva.huisdier;

public class Main {
    public static void main(String[] args) {
        Hond jaapie = new Hond("Jaapie", false);
        jaapie.maakGeluid();
        boolean isGevaarlijk = jaapie.isGevaarlijk();
        System.out.printf("Is de hond gevaarlijk? %b%n", isGevaarlijk);
        System.out.println();

        // hamster, deze override niet maakGeluid() dus de "default" methode maakGeluid() uit Huisdier wordt aangeroepen
        Hamster frutsel = new Hamster("Frutsel", false);
        frutsel.maakGeluid();
        frutsel.knagen();

        // lege regel elke keer
        System.out.println();

        // twee soorten kat instanties
        // specfiek aantal levens
        Kat frederik = new Kat("Frederik", "Britse korthaar", 5);
        // kat, met constructor chaining en toString()
        Kat bertrand = new Kat("Bertrand", "Britse korthaar");

        System.out.println(frederik);
        System.out.println(bertrand);

        System.out.println();

        // Huisdier direct instantieren, parent class
        Huisdier huisdier = new Huisdier("Naam");
        // we kunnen alleen maakGeluid aanroepen, meer heeft deze base/parent/super class niet
        huisdier.maakGeluid();
    }
}