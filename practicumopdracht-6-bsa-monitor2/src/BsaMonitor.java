import java.util.Scanner;



public class BsaMonitor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] SUBJECT_NAMES = {"Engels", "Personal & Project Skills", "Programming", "Project FYS",
                                  "User Interaction", "Wiskunde", "Databases", "Object Oriented Programming 1",
                                  "Business", "Nederlands", "Object Oriented Programming 2",
                                  "Project Agile Development", "Research & Communication Skills", "Databases 2",
                                  "Infrastructure"};
        int[] subjectPoints = {1, 4, 3, 12, 3, 2, 3, 3, 3, 1, 3, 12, 4, 3, 3};
        double[] subjectScores = new double[SUBJECT_NAMES.length];

        System.out.println("Voer behaalde cijfers in: ");
        for (int i = 0; i < subjectScores.length; i++) {
            System.out.printf("%s: ", SUBJECT_NAMES[i]);
            subjectScores[i] = input.nextDouble();

            while (subjectScores[i] < 1.0 || subjectScores[i] > 10.0) {
                System.out.print("Ongeldige input! Een cijfer tussen de 1 - 10: ");
                subjectScores[i] = input.nextDouble();
            }
        }

        int achievedPoints = 0;
        int maxPoints = 0;
        for (int i = 0; i < subjectScores.length; i++) {
            maxPoints += subjectPoints[i];
            if (subjectScores[i] < 5.5) {
                subjectPoints[i] = 0;
            }
            achievedPoints += subjectPoints[i];
        }

        for (int i = 0; i < subjectScores.length; i++) {
            System.out.printf("\nVak/Project: %-32s Cijfer: %4.1f Behaalde punten: %d", SUBJECT_NAMES[i], subjectScores[i], subjectPoints[i]);
        }

        System.out.printf("\n\nTotaal behaalde studiepunten: %d/%d\n", achievedPoints, maxPoints);

        int minPoints = maxPoints - (maxPoints / 5);
        if (achievedPoints < minPoints) {
            System.out.println("PAS OP! Je ligt op schema voor een negatief BSA!");
        }
    }
}
