import java.util.Scanner;

/**
 * Program that counts from 1 to the max given, replacing the 'plofgetal' with 'plof'.
 *
 * @author Tim Knops
 */

public class Plof {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Asks for the plofnumber and then checks to see if its between 2 or 9, if not, it asks again until right
        int plofNumber;
        System.out.print("Wat is het plofgetal (2..9)? ");
        plofNumber = input.nextInt();
        while (plofNumber < 2 || plofNumber > 9) {
            System.out.print("Onjuist plofgetal! Vul een geldig plofgetal in (2..9): ");
            plofNumber = input.nextInt();
        }

        // Asks for the user input of what the max number to count up to should be
        System.out.print("Tot en met welk getal moet ik tellen? ");
        int max = input.nextInt();

        // Prints out 1 to max, replacing the number that is divisible by the plofNumber by "plof"
        for (int i = 1; i <= max; i++) {
            if (i % plofNumber == 0) {
                System.out.print("plof ");
            } else {
                System.out.printf("%d ", i);
            }
        }
    }
}
