import java.util.Scanner;

/**
 * Calculates your BMI based on input
 *
 * @author Tim Knops
 */

public class VervolgBMI {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Asks for input from user and stores it
        System.out.print("Gewicht in kg: ");
        double weight = input.nextDouble();
        System.out.print("Length in cm: ");
        double length = input.nextDouble();

        // Calculates BMI and prints it to the console
        length /= 100;
        double bmi = (weight / (Math.pow((length), 2)));
        System.out.printf("\nBMI: %.1f ", bmi);

        // Prints out how healthy your BMI is
        if (bmi < 18.5) {
            System.out.println("(Ondergewicht)");
        } else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.println("Gezond Gewicht");
        } else if (bmi >= 25.0 && bmi < 30.0) {
            System.out.println("Overgewicht");
        } else {
            System.out.println("Obesitas");
        }
    }
}