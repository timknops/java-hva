import java.util.Scanner;

/**
 * Program to input the grades of multiple people, which will then give an average grade, the amount of good grades
 * and the highest grade.
 *
 * @author Tim Knops
 */

public class TentamenCijfers {

    /**
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hoeveel cijfers wilt u invoeren? ");
        int amount = input.nextInt();

        // Input validation to make sure the amount isn't lower then 0.
        while (amount <= 0) {
            System.out.println("Aantal cijfers moet groter zijn dan 0!");
            System.out.print("Hoeveel cijfers wilt u invoeren? ");
            amount = input.nextInt();
        }

        // Initializing an array and putting the user input in the array.
        double[] grades = new double[amount];
        for (int i = 1; i <= amount; i++) {
            System.out.printf("Cijfer Student %d: ", i);
            grades[i - 1] = input.nextDouble();
        }

        double average = getAverage(grades);
        int goodGrades = getGoodGrades(grades);
        double highestGrade = getHighestGrade(grades);

        System.out.printf("\nAantal cijfers   : %d\n", amount);
        System.out.printf("Gemiddelde cijfer: %.1f\n", average);
        System.out.printf("Aantal voldoendes: %d\n", goodGrades);
        System.out.printf("Hoogste Cijfer   : %.1f\n", highestGrade);
    }

    /**
     * Method calculates the average amount of the array parameter.
     *
     * @param grades Array of grades from the user input.
     * @return Average of the array parameter.
     */

    static double getAverage(double[] grades) {
        double num = 0;
        for (double grade : grades) {
            num += grade;
        }

        return num / grades.length;
    }

    /**
     * Method counts the amount of grades that are higher than 5.5.
     *
     * @param grades Array of grades from the user input.
     * @return The amount of grades from the array that are above 5.5.
     */

    static int getGoodGrades(double[] grades) {
        int num = 0;
        for (double grade : grades) {
            if (grade >= 5.5) {
                num++;
            }
        }

        return num;
    }

    /**
     * Method looks for the highest number within the array parameter.
     *
     * @param grades Array of grades from the user input.
     * @return The highest grade within the array of grades.
     */

    static double getHighestGrade(double[] grades) {
        double highestGrade = 0;
        for (double grade : grades) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
        }

        return highestGrade;
    }
}
