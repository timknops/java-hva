/**
 * Calculates your age in venus years based on the birthyear of the user input.
 *
 * @author Tim Knops
 */

import java.util.Scanner;

public class LeeftijdBerekening {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int CURRENT_YEAR = 2022;
        final double VENUS_YEAR = 1 / 0.62;

        System.out.print("Wat is je naam? ");
        String name = input.nextLine();
        System.out.print("Wat is je geboortejaar? ");
        int birthyear = input.nextInt();

        int age = CURRENT_YEAR - birthyear;
        double venusAge = age * VENUS_YEAR;

        System.out.printf("Beste %s, in %d zal je leeftijd %d zijn.\n", name, CURRENT_YEAR, age);
        System.out.printf("En je leeftijd is dan %.15f in venusjaren.\n", venusAge);
    }
}
