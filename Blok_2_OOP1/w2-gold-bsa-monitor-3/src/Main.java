import java.util.Scanner;

/**
 * Dit programma laat de gebruiker hun behaalde cijfer voor de vakken van het eerste semester van HBO-ICT invullen,
 * afhankelijk van de ingevulde cijfers laat geeft het programma het BSA.
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

    /**
     * Vult alle vakken in de array voor het eerste semester.
     *
     * @param Vak   array met vak objecten
     */
    private static void invullenVakken(Vak[] Vak) {
        final String[] VAK_NAMEN = {"Fasten Your Seatbelts", "Programming", "User Interation",
                "Personal & Project Skills", "Databases", "Object Oriented Programming 1", "Wiskunde", "Engels"};
        final int[] VAK_PUNTEN = {12, 3, 3, 4, 3, 3, 2, 1};

        for (int i = 0; i < Vak.length; i++) {
            Vak[i] = new Vak(VAK_NAMEN[i], VAK_PUNTEN[i]);
        }
    }

    /**
     * Vraagt om de gebruikersinput voor het invullen van de behaalde cijfers van elk vak.
     *
     * @param Vak   array met vak objecten
     */
    private static void invullenBehaaldeCijfers(Vak[] Vak) {
        System.out.println("Voer behaalde cijfers in:");

        for (Vak vak : Vak) {
            System.out.printf("%s: ", vak.getNaam());
            vak.setCijfer(scanner.nextDouble());
        }

        System.out.println();
    }

    /**
     * Print de de resultaten van alle vakken, en of de studiepunten zijn behaald, afhankelijk van het behaalde cijfer.
     *
     * @param Vak   array met vak objecten
     */
    private static void printResultaten(Vak[] Vak) {
        for (Vak vak : Vak) {
            System.out.printf("Vak/Project: %-30s Cijfer: %4.1f Behaalde punten: %2d\n",
                    vak.getNaam(), vak.getCijfer(), vak.gehaaldePunten());
        }
    }

    /**
     * Berekent het bsa advies voor alle opgegeven vakken en print uit of dit een negatief advies is of niet.
     *
     * @param Vak   array met vak objecten
     */
    private static void bsaAdvies(Vak[] Vak) {
        int behaaldePunten = 0, maxPunten = 0;
        for (Vak vak : Vak) {
            behaaldePunten += vak.gehaaldePunten();
            maxPunten += vak.getPunten();
        }

        System.out.printf("\nTotaal behaalde studiepunten: %d/%d\n", behaaldePunten, maxPunten);

        // Minimale aantal punten dat nodig is voor een positief BSA is 5/6 van de max aantal punten.
        int minPunten = maxPunten - (maxPunten  / 5);
        if (behaaldePunten < minPunten) {
            System.out.println("PAS OP! Je ligt op schema voor een negatief BSA!");
        }
    }
}