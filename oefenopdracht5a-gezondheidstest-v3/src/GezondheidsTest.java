import java.util.Scanner;

/**
 * Program that tells you whether you lie within a healthy range in terms of health.
 *
 * @author Tim Knops
 */

public class GezondheidsTest {

    /**
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double  HARTRATE_MIN = 55, HARTRATE_MAX = 90, BODY_TEMP_MIN = 36.3, BODY_TEMP_MAX = 37.5,
                TOP_PRESSURE_MIN = 100, TOP_PRESSURE_MAX = 140;

        // Asking for user input.
        System.out.print("Wat is uw hartslag (slagen per minuut): ");
        double hartRate = input.nextDouble();
        System.out.print("Wat is uw lichaamstemperatuur (in graden Celsius): ");
        double bodyTemperature = input.nextDouble();
        System.out.print("Wat is uw bovendruk (mm Hg): ");
        double topPressure = input.nextDouble();

        // Checks if all user inputs lie within a certain range.
        if (isBetween(hartRate, HARTRATE_MIN, HARTRATE_MAX)) {
            System.out.println("Uw hartslag is gezond");
        } else {
            System.out.println("Uw hartslag is *niet* gezond");
        }

        if (isBetween(bodyTemperature, BODY_TEMP_MIN, BODY_TEMP_MAX)) {
            System.out.println("Uw lichaamstemperatuur is gezond");
        } else {
            System.out.println("Uw lichaamstemperatuur is *niet* gezond");
        }

        if (isBetween(topPressure, TOP_PRESSURE_MIN, TOP_PRESSURE_MAX)) {
            System.out.println("Uw bovendruk is gezond");
        } else {
            System.out.println("Uw bovendruk is *niet* gezond");
        }
    }

    /**
     * Method returns either true or false based on if the input lies within the min/max range.
     *
     * @param amount Amount to be checked if it lies within a range.
     * @param min Minimum for the amount to be.
     * @param max Maximum for the amount to be.
     * @return Whether the amount lies within the min/max parameters.
     */

    static boolean isBetween(double amount, double min, double max) {
        return (amount >= min && amount <= max);
    }
}
