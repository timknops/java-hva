import java.util.Scanner;

/**
 * Calculates your conversion amount based on your input
 *
 * @author Tim Knops
 */

public class MoneyExchange {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaring conversion constants
        double US_CONVERSION = 1.0089, GB_CONVERSION = 1.1432, YEN_CONVERSION = 0.0070;

        // Asks for user input and stores it
        System.out.print("Valuta (1 = US dollar, 2 = GB pounds, 3 = Yen): ");
        int currency = input.nextInt();
        System.out.print("In te wisselen bedrag (alleen in hele getallen): ");
        int amount = input.nextInt();

        // Calculates return amount and changes based on the user input
        double returnAmount = 0;
        String str = "";
        switch (currency) {
            case 1 -> {
                returnAmount = amount * US_CONVERSION;
                str = "US";
            }
            case 2 -> {
                returnAmount = amount * GB_CONVERSION;
                str = "GB";
            }
            case 3 -> {
                returnAmount = amount * YEN_CONVERSION;
                str = "YEN";
            }
        }

        System.out.printf("Voor %d %s krijgt u %.2f Euro.\n", amount, str, returnAmount);
    }
}