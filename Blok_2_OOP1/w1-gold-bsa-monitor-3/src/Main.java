import java.util.Scanner;

/**
 * Dit programma laat de gebruiker vakken, punten, en hun behaalde cijfer toevoegen. En geeft daarna weer of
 * de studiepunten zijn behaald.
 *
 * @author Tim Knops
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vak fys = new Vak("Fasten your Seatbelts", 12);

        System.out.printf("Voer behaalde cijfer voor %s in: ", fys.getNaam());
        fys.setCijfer(scanner.nextDouble());

        System.out.printf("Vak/Project: %s  Cijfer: %.1f  Punten: %d\n",
                fys.getNaam(), fys.getCijfer(), fys.gehaaldePunten());
    }
}
