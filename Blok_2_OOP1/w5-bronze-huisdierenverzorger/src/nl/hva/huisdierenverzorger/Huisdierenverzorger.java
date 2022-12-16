package nl.hva.huisdierenverzorger;

import java.util.ArrayList;

public class Huisdierenverzorger {

//    ArrayList<Kat> katten = new ArrayList<>();
//    ArrayList<Hond> honden = new ArrayList<>();
//    ArrayList<Hamster> hamsters = new ArrayList<>();
//
//    public void voegHondToe(Hond hond) {
//        honden.add(hond);
//    }
//
//    public void voegKatToe(Kat kat) {
//        katten.add(kat);
//    }
//
//    public void voegHamsterToe(Hamster hamster) {
//        hamsters.add(hamster);
//    }

    ArrayList<Huisdier> huisdieren = new ArrayList<>();

    public void voegHuisdierToe(Huisdier dier) {
        huisdieren.add(dier);
    }


    public void laatAlleDierenGeluidMaken() {
        for (int i = 0; i < huisdieren.size(); i++) {
            Huisdier huisdier = huisdieren.get(i);
            huisdier.maakGeluid();
        }
    }

    /**
     * Laat alleen alle hamsters knagen
     */
    public void laatHamstersKnagen() {
        for (int i = 0; i < huisdieren.size(); i++) {
            Huisdier huisdier = huisdieren.get(i);

            // controleer of we wel veilig kunnen downcasten!
            if(huisdier instanceof Hamster) {
                //hier binnen kunnen we veilig downcasten
                Hamster hamster = (Hamster) huisdier;
                hamster.knagen();
            }
        }
    }

    /**
     * Print gevaarlijke honden
     */
    public void printGevaarlijkeHonden() {
        for (int i = 0; i < huisdieren.size(); i++) {
            Huisdier huisdier = huisdieren.get(i);
            if(huisdier instanceof Hond) {
                Hond hond = (Hond) huisdier;
                if(hond.isGevaarlijk()) {
                    System.out.printf("Naam gevaarlijke hond: %s%n", hond.getNaam());
                }
            }
        }
    }

}

