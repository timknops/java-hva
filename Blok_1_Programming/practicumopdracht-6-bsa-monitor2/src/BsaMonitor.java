import java.util.Scanner;

/**
 * Program allows the user to input their grades for every subject in the year 1 of HBO-ICT SE. Based on the grades,
 * it tells the user whether they are on track for a positive BSA or not.
 *
 * @autor Tim Knops.
 */

public class BsaMonitor {

    /**
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double MIN_GRADE = 5.5;
        final String[] SUBJECT_NAMES = {"Engels", "Personal & Project Skills", "Programming", "Project FYS",
                                  "User Interaction", "Wiskunde", "Databases", "Object Oriented Programming 1",
                                  "Business", "Nederlands", "Object Oriented Programming 2",
                                  "Project Agile Development", "Research & Communication Skills", "Databases 2",
                                  "Infrastructure"};
        int[] subjectPoints = {1, 4, 3, 12, 3, 2, 3, 3, 3, 1, 3, 12, 4, 3, 3};
        double[] subjectScores = new double[SUBJECT_NAMES.length];


        // Using a for loop to continuously ask for the grade of the user, then stores it in the subjectScores array.
        System.out.println("Voer behaalde cijfers in: ");
        for (int i = 0; i < subjectScores.length; i++) {
            System.out.printf("%s: ", SUBJECT_NAMES[i]);
            subjectScores[i] = input.nextDouble();

            // Input validation, checks to see if the grade is within 1 and 10.
            while (subjectScores[i] < 1.0 || subjectScores[i] > 10.0) {
                System.out.print("Ongeldige input! Een cijfer tussen de 1 - 10: ");
                subjectScores[i] = input.nextDouble();
            }
        }

        // Loops through the user input scores array, and if the array has a grade that is less than the minimum grade,
        // it sets the points achieved equal to 0.
        int achievedPoints = 0;
        int maxPoints = 0;
        for (int i = 0; i < subjectScores.length; i++) {
            maxPoints += subjectPoints[i];
            if (subjectScores[i] < MIN_GRADE) {
                subjectPoints[i] = 0;
            }
            achievedPoints += subjectPoints[i];
        }

        // Prints out the info on each subject, using printf to format the output.
        for (int i = 0; i < subjectScores.length; i++) {
            System.out.printf("\nVak/Project: %-32s Cijfer: %4.1f Behaalde punten: %d",
                               SUBJECT_NAMES[i], subjectScores[i], subjectPoints[i]);
        }

        System.out.printf("\n\nTotaal behaalde studiepunten: %d/%d\n", achievedPoints, maxPoints);

        // Gives a warning message if the achieved points is less than 5/6 of the total amount of points that
        // can be achieved.
        int minPoints = maxPoints - (maxPoints / 5);
        if (achievedPoints < minPoints) {
            System.out.println("PAS OP! Je ligt op schema voor een negatief BSA!");
        }
    }
}
