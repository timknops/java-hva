package nl.hva.registratiesysteem;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Hoeveel personen wil je registreren? : ");
        int aantalPersonen = scanner.nextInt();
        scanner.nextLine();

        Object[] arr = new Object[aantalPersonen];

        getPersoonInformatie(arr);
        printPersonenInformatie(arr);
    }

    private static void getPersoonInformatie(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Wat is de naam van persoon %d: ", i + 1);
            String naam = scanner.nextLine();

            System.out.printf("Wat is de woonplaats van %s?: ", naam);
            String woonplaats = scanner.nextLine();

            System.out.printf("Is %s een student of docent?: ", naam);
            String studentOfDocent = scanner.nextLine();

            if (studentOfDocent.equals("student")) {
                System.out.printf("Hoeveel studiepunten heeft %s?: ", naam);
                int aantalStudiepunten = scanner.nextInt();
                
                arr[i] = new Student(naam, woonplaats, aantalStudiepunten);
            } else {
                arr[i] = new Docent(naam, woonplaats);
            }

            System.out.println();
        }
    }

    private static void printPersonenInformatie(Object[] arr) {
        StringBuilder str = new StringBuilder();

        str.append("Personeninfo:\n");
        for (int i = 0; i < arr.length; i++) {
            String counter = i + 1 + ". ";
            str.append(counter).append(arr[i].toString());
        }

        System.out.println(str);
    }
}
