package practicumopdracht.data;

import practicumopdracht.models.Workout;

import java.io.*;
import java.time.LocalDate;

public class BinaryWorkoutDAO extends WorkoutDAO {

    private static final String FILENAME = "src/resources/workouts.dat";


    @Override
    public boolean save() {
        File file = new File(FILENAME);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
            ) {
            dataOutputStream.writeInt(models.size()); // So that we know the size that we need to loop through when loading.

            for (Workout model : models) {
                dataOutputStream.writeUTF(model.getName());
                dataOutputStream.writeUTF(String.valueOf((model.getDate())));
                dataOutputStream.writeBoolean(model.isCompleted());
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

        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            int totalModels = dataInputStream.readInt();

            for (int i = 0; i < totalModels; i++) {
                String name = dataInputStream.readUTF();
                LocalDate date = LocalDate.parse(dataInputStream.readUTF());
                boolean isCompleted = dataInputStream.readBoolean();

                models.add(new Workout(name, date, isCompleted));
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
