package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Exercise;
import java.io.*;

public class ObjectExerciseDAO extends ExerciseDAO {

    private static final String FILENAME = "src/resources/exercises.obj";

    @Override
    public boolean save() {
        File file = new File(FILENAME);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeInt(models.size()); // So that we know the size that we need to loop through when loading.

            for (Exercise model : models) {
                // Because the 'belongsTo' field in the Exercise model is transient. The Reference to the master model
                // is not saved. Instead, the id is saved that belongs to the master model.
                objectOutputStream.writeInt(MainApplication.getWorkoutDAO().getIdFor(model.getBelongsTo()));
                objectOutputStream.writeObject(model);
            }

            return true;
        } catch (Exception e) {
            System.err.println("Er is iets fout gegaan!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean load() {
        File file = new File(FILENAME);

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            int totalModels = objectInputStream.readInt();

            for (int i = 0; i < totalModels; i++) {
                int referenceToWorkout = objectInputStream.readInt();
                Exercise exercise = (Exercise) objectInputStream.readObject();

                models.add(new Exercise(MainApplication.getWorkoutDAO().getById(referenceToWorkout), exercise.getName(),
                        exercise.getSets(), exercise.getReps(), exercise.getWeight(), exercise.getNotes(),
                        exercise.getRateOfPerceivedExertion()));
            }

            return true;
        } catch (FileNotFoundException e) {
            System.err.printf("Bestand: %s niet gevonden!\n", file.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Er gaat iets fout!");
            e.printStackTrace();
        }

        return false;
    }
}
