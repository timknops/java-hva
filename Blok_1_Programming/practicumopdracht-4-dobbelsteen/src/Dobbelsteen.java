import java.util.Scanner;

/**
 * Program that throws a dice until the thrown dice is equal to 6.
 *
 * @author Tim Knops
 */

public class Dobbelsteen {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Welk karakter moet ik gebruiken voor het oog: ");
        String userInput = input.next();

        // Runs the loop until its equal to 6
        int choice = 0;
        while (choice != 6) {
            // Generates a random number between 1 and 6
            choice = (int) (Math.random() * 6) + 1;

            // Prints the dice depended on the random number generated
            char e = userInput.charAt(0); // e is the first character of the user input
            switch (choice) {
                case 1 -> {
                    System.out.printf("\n   \n %c \n   \n", e);
                }
                case 2 -> {
                    System.out.printf("\n%c  \n   \n  %c\n", e, e);
                }
                case 3 -> {
                    System.out.printf("\n%c  \n %c \n  %c\n", e, e, e);
                }
                case 4 -> {
                    System.out.printf("\n%c %c\n   \n%c %c\n", e, e, e, e);
                }
                case 5 -> {
                    System.out.printf("\n%c %c\n %c \n%c %c\n", e, e, e, e, e);
                }
                case 6 -> {
                    System.out.printf("\n%c %c\n%c %c\n%c %c\n", e, e, e, e, e, e);
                }
            }
        }
    }
}
