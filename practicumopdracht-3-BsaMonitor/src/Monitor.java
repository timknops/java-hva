
import java.util.Scanner;

public class Monitor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final String[] NAMES = {"Fasten your Seatbelts", "Programming", "Databases", "Personal & Project Skills",
                                "Infrastructure", "Network Engineering"};
        final int FYS = 12,
                  PROGRAMMING = 3,
                  DATABASES = 3,
                  PERSONAL_PROJECT_SKILLS = 4,
                  INFRASTRUCTURE = 0,
                  NETWORKENGINEERING = 0;
//        final int[] VAKKEN = {FYS, PROGRAMMING, DATABASES, PERSONAL_PROJECT_SKILLS, INFRASTRUCTURE, NETWORKENGINEERING};

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

        System.out.printf("\nVak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[0], fys);
        System.out.printf("Vak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[1], programming);
        System.out.printf("Vak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[2], databases);
        System.out.printf("Vak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[3], personalProjectSkills);
        System.out.printf("Vak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[4], infrastructure);
        System.out.printf("Vak/Project: %s       Cijfer: %.1f Behaalde Punten: \n", NAMES[5], networkEngineering);





    }
}
