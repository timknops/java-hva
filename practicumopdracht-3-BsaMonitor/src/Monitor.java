
import java.util.Scanner;

public class Monitor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String[] NAMES = {"Fasten your Seatbelts    ",
                                "Programming              ",
                                "Databases                ",
                                "Personal & Project Skills",
                                "Infrastructure           ",
                                "Network Engineering      "};
        int         fysPoints = 12,
                    programmingPoints = 3,
                    databasePoints = 3,
                    personalProjectSkillsPoints = 4,
                    infrastructurePoints = 3,
                    networkEngineeringPoints = 3;
        int[] points = {fysPoints, programmingPoints, databasePoints, personalProjectSkillsPoints, infrastructurePoints, networkEngineeringPoints};
        final int MAX_POINTS = 28;

        float fys, programming, databases, personalProjectSkills, infrastructure, networkEngineering;
        System.out.println("Voor behaalde cijfers in: ");
        System.out.print("Fasten your Seatbelts: ");
        fys = input.nextFloat();
        System.out.print("Programming: ");
        programming = input.nextFloat();
        System.out.print("Databases: ");
        databases = input.nextFloat();
        System.out.print("Personal & Project Skills: ");
        personalProjectSkills = input.nextFloat();
        System.out.print("Infrastructure: ");
        infrastructure = input.nextFloat();
        System.out.print("Network Engineering: ");
        networkEngineering = input.nextFloat();

        float[] grades = {fys, programming, databases, personalProjectSkills, infrastructure, networkEngineering};
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 5.5) {
                points[i] = 0;
            }
        }

        System.out.printf("\nVak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[0], grades[0], points[0]);
        System.out.printf("Vak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[1], grades[1], points[1]);
        System.out.printf("Vak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[2], grades[2], points[2]);
        System.out.printf("Vak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[3], grades[3], points[3]);
        System.out.printf("Vak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[4], grades[4], points[4]);
        System.out.printf("Vak/Project: %s   Cijfer: %.1f Behaalde Punten: %d\n", NAMES[5], grades[5], points[5]);
    }
}
