package practicumopdracht.data;

import practicumopdracht.models.Workout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextWorkoutDAO extends WorkoutDAO {

    private static final String FILENAME = "src/resources/workouts.txt";

    @Override
    public boolean save() {
        File file = new File(FILENAME);

        try (PrintWriter printWriter = new PrintWriter(file)){
            printWriter.println(models.size()); // So that we know the size we need to loop through when loading.
            for (Workout model : models) {
                printWriter.printf("%s\n%s\n%b\n", model.getName(), model.getDate(), model.isCompleted());
            }

            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Bestand is niet gevonden!");
        } catch (Exception e) {
            System.err.println("Er gaat iets fout!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean load() {
        File file = new File(FILENAME);;

        try (Scanner scanner = new Scanner(file)){
            int totalWorkouts = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < totalWorkouts; i++) {
                String name = scanner.nextLine();
                LocalDate date = LocalDate.parse(scanner.nextLine());
                boolean isCompleted = scanner.nextBoolean();
                scanner.nextLine();

                models.add(new Workout(name, date, isCompleted));
            }

            return true;
        } catch (FileNotFoundException e) {
            System.err.printf("Bestand: %s niet gevonden!\n", file.getAbsolutePath());
        } catch (NoSuchElementException ignored) {

        } catch (Exception e) {
            System.err.println("Er gaat iets fout!");
            e.printStackTrace();
        }

        return false;
    }
}
