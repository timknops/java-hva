import java.time.LocalDate;
import java.util.Scanner;

/**
 * Dit programma laat de gebruiker studenten toevoegen aan een door hem gekozen klas, waarvan alle studenten vervolgens
 * worden weegegeven.
 *
 * @author Tim Knops
 */
public class Main {

    public static void main(String[] args) {
        final int MAX_AANTAL_STUDENTEN = 30;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Naam van de klas: ");
        Klas klas = new Klas(scanner.nextLine());

        int studentenCounter = 1, studentNummer;
        do {
            System.out.printf("\nStudent %d\n", studentenCounter);

            System.out.print("Studentnummer: ");
            studentNummer = scanner.nextInt();
            if (studentNummer == 0) { // Als de input 0 is bij de input van het studentnummer, eindigd het programma.
                break;
            }

            System.out.print("Voornaam: ");
            String voornaam = scanner.next();
            System.out.print("Achternaam: ");
            String achternaam = scanner.next();
            System.out.print("Geboortedatum (DD-MM-YYYY): ");
            String geboortedatum = scanner.next();

            System.out.print("Straat: ");
            String straat = scanner.next();
            System.out.print("Huisnummer: ");
            int huisnummer = scanner.nextInt();

            String postcode;
            // Validatie van de postcode.
            do {
                System.out.print("Postcode: ");
                postcode = scanner.next();
                if (!Adres.isGeldigePostcode(postcode)) {
                    System.out.println("\nOngeldige postcode! Probeer opniew\n");
                }
            } while (!Adres.isGeldigePostcode(postcode));

            System.out.print("Plaats: ");
            String plaats = scanner.next();

            String[] geboortedatumArr = geboortedatum.split("-");

            // Adres en student worden aangemaakt en toegevoegd aan de klas.
            Adres adres = new Adres(straat, huisnummer, postcode, plaats);
            Student student = new Student(studentNummer, voornaam, achternaam,
                    LocalDate.of(Integer.parseInt(geboortedatumArr[2]),
                                 Integer.parseInt(geboortedatumArr[1]),
                                 Integer.parseInt(geboortedatumArr[0])), adres);
            klas.voegStudentToe(student);

            studentenCounter++;
        } while (klas.getAantalStudenten() < MAX_AANTAL_STUDENTEN);

        if (klas.getAantalStudenten() == MAX_AANTAL_STUDENTEN) {
            System.out.println("\nMaximale aantal studenten voor deze klas bereikt!\n");
        }

        System.out.println();

        // Print de klas en alle studenten met de desbetreffende informatie.
        String alleStudenten = klas.toString();
        System.out.println(alleStudenten);
    }
}
