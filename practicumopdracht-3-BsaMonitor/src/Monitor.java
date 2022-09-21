import java.util.Scanner;

public class Monitor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX_POINTS = 28;
        final String[] NAMES = {"Fasten your Seatbelts    ",
                                "Programming              ",
                                "Databases                ",
                                "Personal & Project Skills",
                                "Infrastructure           ",
                                "Network Engineering      "};
        int     fysPoints = 12,
                programmingPoints = 3,
                databasePoints = 3,
                personalProjectSkillsPoints = 4,
                infrastructurePoints = 3,
                networkEngineeringPoints = 3;
        int[] points = {fysPoints, programmingPoints, databasePoints,
                        personalProjectSkillsPoints, infrastructurePoints,
                        networkEngineeringPoints};

        float[] grades = new float[6];
        for (int i = 0; i < NAMES.length; i++) {
            System.out.printf("%s: ", NAMES[i].trim());
            grades[i] = input.nextFloat();
        }

        System.out.println();

        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 5.5) {
                points[i] = 0;
            }
            sum += points[i];
            System.out.printf("Vak/Project: %s Cijfer: %.1f Behaalde Punten: %d\n", NAMES[i], grades[i], points[i]);
        }

        System.out.printf("\nTotaal behaalde studiepunten: %d/%d\n", sum, MAX_POINTS);

        int minPoints = MAX_POINTS - (MAX_POINTS / 5);
        if (sum < minPoints) {
            System.out.println("PAS OP: Je ligt op schema voor een negatief BSA!");
        }
    }
}
