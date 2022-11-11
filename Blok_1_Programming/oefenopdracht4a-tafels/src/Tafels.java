import java.util.Scanner;

/**
 * Prints out the table based on user input.
 *
 * @author Tim Knops
 */

public class Tafels {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // True until user input is equal to 0
        while (true) {
            System.out.print("Welke tafel wilt u printen (0=stoppen)? ");
            int table = input.nextInt();
            // Checks to see if the user wants to stop
            if (table == 0) {
                break;
            }

            System.out.print("Hoeveel getallen wilt u printen? ");
            int number = input.nextInt();

            System.out.printf("\nDe tafel van %d:\n", table);

            // Loops until the requested amount of numbers is reached
            int startingTable = table;
            for (int i = 0; i < number; i++) {
                // Prints an empty line if there are 5 numbers on the same line
                if (i % 5 == 0 && i != 0) {
                    System.out.println();
                }

                // Prints out the table with a specified spacing of 6
                System.out.printf("%6d", startingTable);
                startingTable += table;
            }
            System.out.print("\n\n");
        }
    }
}
