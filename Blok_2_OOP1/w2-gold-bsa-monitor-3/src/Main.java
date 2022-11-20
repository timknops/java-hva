import java.util.Scanner;

/**
 * Dit programma laat de gebruiker vakken, punten, en hun behaalde cijfer toevoegen. En geeft daarna weer of
 * de studiepunten zijn behaald.
 *
 * @author Tim Knops
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int AANTAL_VAKKEN = 8;
        Vak[] Vak = new Vak[AANTAL_VAKKEN];

        invullenVakken(Vak);
        invullenBehaaldeCijfers(Vak);
        printResultaten(Vak);
        bsaAdvies(Vak);
    }

    private static void invullenVakken(Vak[] Vak) {
        final String[] vakNamen = {"Fasten Your Seatbelts", "Programming", "User Interation",
                "Personal & Project Skills", "Databases", "Object Oriented Programming 1", "Wiskunde", "Engels"};
        final int[] vakPunten = {12, 3, 3, 4, 3, 3, 2, 1};

        for (int i = 0; i < Vak.length; i++) {
            Vak[i] = new Vak(vakNamen[i], vakPunten[i]);
        }
    }

    private static void invullenBehaaldeCijfers(Vak[] Vak) {
        System.out.println("Voer behaalde cijfers in:");

        for (Vak vak : Vak) {
            System.out.printf("%s: ", vak.getNaam());
            vak.setCijfer(scanner.nextDouble());
        }

        System.out.println();
    }

    private static void printResultaten(Vak[] Vak) {
        for (Vak vak : Vak) {
            System.out.printf("Vak/Project: %-30s Cijfer: %4.1f Behaalde punten: %2d\n",
                    vak.getNaam(), vak.getCijfer(), vak.gehaaldePunten());
        }
    }

    private static void bsaAdvies(Vak[] Vak) {
        int behaaldePunten = 0, maxPunten = 0;
        for (Vak vak : Vak) {
            maxPunten += vak.getPunten();
            behaaldePunten += vak.gehaaldePunten();
        }

        System.out.printf("\nTotaal behaalde studiepunten: %d/%d\n", behaaldePunten, maxPunten);

        int minPunten = maxPunten - (maxPunten  / 5);
        if (behaaldePunten < minPunten) {
            System.out.println("PAS OP! Je ligt op schema voor een negatief BSA!");
        }
    }
}