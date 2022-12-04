import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Adres adres = new Adres("hans", 10, "1625GH", "Hoorn");
//        Student student = new Student(500849389,
//                "Hans", "Klok", LocalDate.of(2001, 1, 13), adres);
//
//        Student student2 = new Student(55532534, "Peter", "Jan",
//                LocalDate.of(2002, 2, 22), adres);

        System.out.print("Naam van de klas: ");
        Klas klas = new Klas(scanner.nextLine());

        int studentenCounter = 1, studentNummer;
        do {
            System.out.printf("Student %d\n", studentenCounter);

            System.out.print("Studentnummer: ");
            studentNummer = scanner.nextInt();
            if (studentNummer == 0) {
                break;
            }
            System.out.print("Voornaam: ");
            String voornaam = scanner.next();
            System.out.print("Achternaam: ");
            String achternaam = scanner.next();
            System.out.print("Geboortedatum (DD-MM-YYY): ");
            String geboortedatum = scanner.next();

            System.out.print("Straat: ");
            String straat = scanner.next();
            System.out.print("Huisnummer: ");
            int huisnummer = scanner.nextInt();

            String postcode;
            while (true) {
                postcode = scanner.next();
                if (!Adres.isGeldigePostcode(postcode)) {
                    System.out.println("Ongeldige postcode! Probeer opniew\n");
                    continue;
                }
                break;
            }

            do {
                postcode = scanner.next();


            } while (!Adres.isGeldigePostcode(postcode));



            String plaats = scanner.next();

            String[] geboortedatumArr = geboortedatum.split("-");

            Adres adres = new Adres(straat, huisnummer, postcode, plaats);
            Student student = new Student(studentNummer, voornaam, achternaam,
                    LocalDate.of(Integer.parseInt(geboortedatumArr[2]),
                                 Integer.parseInt(geboortedatumArr[1]),
                                 Integer.parseInt(geboortedatumArr[0])),
                    adres);
            klas.voegStudentToe(student);

            studentenCounter++;
        } while (klas.getAantalStudenten() < 30);

        if (klas.getAantalStudenten() == 30) {
            System.out.println("Maximale aantal studenten voor deze klas bereikt!\n");
        }


        String alleStudenten = klas.toString();
        System.out.println(alleStudenten);
    }
}
