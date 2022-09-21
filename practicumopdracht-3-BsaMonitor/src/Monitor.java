import java.util.Scanner;

/**
 * Program tells your BSA progression based on the user input.
 *
 * @author Tim Knops
 */
public class Monitor {

    /**
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Declaring constant variables
        final int MAX_POINTS = 28;
        final String[] NAMES = {"Fasten your Seatbelts    ",
                                "Programming              ",
                                "Databases                ",
                                "Personal & Project Skills",
                                "Infrastructure           ",
                                "Network Engineering      "};

        // Declaring variables and storing them in an array
        int     fysPoints = 12,
                programmingPoints = 3,
                databasePoints = 3,
                personalProjectSkillsPoints = 4,
                infrastructurePoints = 3,
                networkEngineeringPoints = 3;
        int[] points = {fysPoints, programmingPoints, databasePoints,
                        personalProjectSkillsPoints, infrastructurePoints,
                        networkEngineeringPoints};

        // Initialising an array and then storing the user input in the array
        float[] grades = new float[6];
        for (int i = 0; i < NAMES.length; i++) {
            System.out.printf("%s: ", NAMES[i].trim());
            grades[i] = input.nextFloat();
        }

        System.out.println();

        // Prints out the class, grade and the total amount of study points received based on how high the grade is
        // Also stores the sum of all points from all the classes
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 5.5) {
                points[i] = 0;
            }
            sum += points[i];
            System.out.printf("Vak/Project: %s Cijfer: %.1f Behaalde Punten: %d\n", NAMES[i], grades[i], points[i]);
        }

        System.out.printf("\nTotaal behaalde studiepunten: %d/%d\n", sum, MAX_POINTS);

        // Prints out the BSA warning message if the points received is less then 5/6 of the MAX_POINTS
        int minPoints = MAX_POINTS - (MAX_POINTS / 5);
        if (sum < minPoints) {
            System.out.println("PAS OP: Je ligt op schema voor een negatief BSA!");
        }
    }
}
