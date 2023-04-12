package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Exercise;
import practicumopdracht.models.Workout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextExerciseDAO extends ExerciseDAO {

    private static final String FILENAME = "src/resources/exercises.txt";

    @Override
    public boolean save() {
        File file = new File(FILENAME);

        try (PrintWriter printWriter = new PrintWriter(file)){
            printWriter.println(models.size()); // So that we know the size we need to loop through when loading.
            for (Exercise model : models) {
                printWriter.printf("%s\n%s\n%s\n%s\n%s\n%s\n%s\n",
                        MainApplication.getWorkoutDAO().getIdFor(model.getBelongsTo()), model.getName(), model.getSets(),
                        model.getReps(), model.getWeight(), model.getRateOfPerceivedExertion(), model.getNotes());
            }

            return true;
        } catch (Exception e) {
            System.err.println("Er gaat iets fout!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean load() {
        File file = new File(FILENAME);

        try (Scanner scanner = new Scanner(file)) {
            int totalExercises = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < totalExercises; i++) {
                Workout workoutId = MainApplication.getWorkoutDAO().getById(Integer.parseInt(scanner.nextLine()));
                String name = scanner.nextLine();
                int sets = Integer.parseInt(scanner.nextLine());
                int reps = Integer.parseInt(scanner.nextLine());
                double weight = Double.parseDouble(scanner.nextLine());
                int rateOfPerceivedExertion = Integer.parseInt(scanner.nextLine());
                String notes = scanner.nextLine();

                models.add(new Exercise(workoutId, name, sets, reps, weight, notes, rateOfPerceivedExertion));
            }

            return true;
        } catch (FileNotFoundException e) {
            System.err.printf("Bestand: %s niet gevonden!\n", file.getAbsolutePath());
        }  catch (Exception e) {
            System.err.println("Er gaat iets fout!");
            e.printStackTrace();
        }

        return false;
    }
}
