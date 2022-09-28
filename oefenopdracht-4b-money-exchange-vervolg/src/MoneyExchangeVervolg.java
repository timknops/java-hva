import java.util.Scanner;

/**
 * Program calculates the exchange amount depending on what currency the user wants to see and what the amount is.
 *
 * @author Tim Knops
 */

public class MoneyExchangeVervolg {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaring constant variables
        String[] CURRENCY_OPTIONS = {"US dollar", "GB pounds", "Yen"};
        double[] EXCHANGE_RATE = {1.03952, 1.11859, 0.00719};
        double TRANSACTION = 0.015;

        // Loop runs until the user input on the currency == 0
        while (true) {
            System.out.printf("Valuta (1 = %s, 2 = %s, 3 = %s, 0 = stop): ",
                              CURRENCY_OPTIONS[0], CURRENCY_OPTIONS[1], CURRENCY_OPTIONS[2]);
            int currency = input.nextInt();

            // Checks to see if the user input is valid
            while (currency < 0 || currency > 3) {
                System.out.println("Ongeldige keuze");
                System.out.printf("Valuta (1 = %s, 2 = %s, 3 = %s, 0 = stop): ",
                        CURRENCY_OPTIONS[0], CURRENCY_OPTIONS[1], CURRENCY_OPTIONS[2]);
                currency = input.nextInt();
            }

            if (currency == 0) {
                break;
            }

            System.out.print("In te wisselen bedrag (alleen hele getallen): ");
            int amount = input.nextInt();

            double amountInEuro = amount * EXCHANGE_RATE[currency-1];
            double transActionCosts = amountInEuro * TRANSACTION;
            double repayAmount = amountInEuro - transActionCosts;

            // Whitespace amount for the yen variant, makes sure that the output is properly formatted
            String yenWhitespace = "";
            if (currency == 3) {
                yenWhitespace = "      ";
            }

            // Printing out all exchange info
            System.out.printf("\n\nIn te wisselen bedrag in %s:%s %20.2f\n", CURRENCY_OPTIONS[currency - 1], yenWhitespace, (double) amount);
            System.out.printf("Waarde in Euro:                     %20.2f\n", amountInEuro);
            System.out.printf("Transactiekosten:                   %20.2f\n", transActionCosts);
            System.out.printf("Uit te betalen in Euro:             %20.2f\n\n", repayAmount);
        }
    }
}
