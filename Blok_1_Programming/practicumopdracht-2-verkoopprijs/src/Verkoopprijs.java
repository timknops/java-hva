/**
 * Calculates sales prices based on input.
 *
 * @author Tim Knops
 */

import java.util.Scanner;

public class Verkoopprijs {
    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double BTW_LAAG = 6, BTW_HOOG = 21;

        // Asks for user input and stores it
        System.out.print("Inkoopprijs: ");
        double inkoopprijs = input.nextDouble();
        System.out.print("Winstmarge: ");
        double winstmarge = input.nextDouble();

        // Calculates sales prices
        winstmarge = (winstmarge / 100) * inkoopprijs;
        double exclusief = inkoopprijs + winstmarge;
        double inclusiefLaag = exclusief * (1 + (BTW_LAAG / 100));
        double inclusiefHoog = exclusief * (1 + (BTW_HOOG / 100));

        // Prints out sales prices to the console
        System.out.printf("Verkoopprijs exclusief BTW : %.2f\n", exclusief);
        System.out.printf("Verkoopprijs inclusief %d%% BTW : %.2f\n", (int) BTW_LAAG, inclusiefLaag);
        System.out.printf("Verkoopprijs inclusief %d%% BTW : %.2f\n", (int) BTW_HOOG, inclusiefHoog);
    }
}
