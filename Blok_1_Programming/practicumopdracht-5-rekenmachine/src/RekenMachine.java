import java.util.Scanner;

/**
 * Simple calculator program that will ask for the calculation you want.
 *
 * @author Tim Knops
 */

public class RekenMachine {

    /**
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Loops until the user input = S.
        while (true) {
            System.out.print("Operator (S = stoppen): ");
            String operatorInput = input.next();

            // Input validation to make sure the user input is a valid operator.
            char characterInput = operatorInput.charAt(0);
            while (!isValidOperator(characterInput)) {
                if (characterInput == 'S') {
                    return;
                }

                System.out.println("Operator is ongeldig\n");
                System.out.print("Operator (S = stoppen): ");
                operatorInput = input.next();
                characterInput = operatorInput.charAt(0);
            }

            System.out.print("Eerste getal: ");
            double num1 = input.nextDouble();
            System.out.print("Tweede getal: ");
            double num2 = input.nextDouble();

            // Prints the calculation
            printCalculation(characterInput, num1, num2);
        }
    }

    /**
     * Method checks whether the given input is one of the supported operators.
     *
     * @param character First character of the user input.
     * @return True or false based on whether the user input is within the array of operators.
     */

    static boolean isValidOperator(char character) {
        final char[] OPERATORS = {'+', '-', '*', '/', '%'};

        // For each loop that checks if the method parameter is equal to one of the operators in the array.
        for (char operator : OPERATORS) {
            if (operator == character) {
                return true;
            }
        }
        return false;
    }

    /**
     * Does the calculation based on the user input and prints it out.
     *
     * @param operator First character of the user input.
     * @param num1 First number used in the calculation.
     * @param num2 Second number used in the calculation.
     */

    static void printCalculation(char operator, double num1, double num2) {
        // Does the calculation based on which operator it is.
        double calculation = 0;
        switch (operator) {
            case ('+') -> {
                calculation = num1 + num2;
            }
            case ('-') -> {
                calculation = num1 - num2;
            }
            case ('*') -> {
                calculation = num1 * num2;
            }
            case ('/') -> {
                calculation = num1 / num2;
            }
            case ('%') -> {
                calculation = num1 % num2;
            }
        }

        // Prints out the final calculation.
        System.out.printf("%.1f %c %.1f = %.1f\n\n", num1, operator, num2, calculation);
    }
}
