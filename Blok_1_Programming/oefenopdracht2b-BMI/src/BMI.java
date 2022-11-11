/**
 * Calculates your BMI based on weight in kg and length in cm.
 *
 * @author Tim Knops
 */

import java.util.Scanner;

public class BMI {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for user input
        System.out.print("Gewicht in kg: ");
        double weight = input.nextDouble();
        System.out.print("Length in cm: ");
        double length = input.nextInt();

        // Converts length in cm to length in m
        length /= 100;

        double BMI = weight / (length * length);

        System.out.printf("BMI: %.2f\n", BMI);
    }
}
