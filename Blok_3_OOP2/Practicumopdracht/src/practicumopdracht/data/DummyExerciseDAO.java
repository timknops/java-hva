package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Exercise;

public class DummyExerciseDAO extends ExerciseDAO {

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        WorkoutDAO workoutModels = MainApplication.getWorkoutDAO();

        models.add(new Exercise(workoutModels.getById(0), "Bench Press", 3, 5, 122,"Letten op houding", 8));
        models.add(new Exercise(workoutModels.getById(1), "Squats", 4, 8, 160, "Warmup niet vergeten!!", 7));
        models.add(new Exercise(workoutModels.getById(1), "Deadlifts", 5, 3, 215.5, "Focussen op bracing.", 8));
        models.add(new Exercise(workoutModels.getById(1), "Lunges", 2, 12, 40, null, 9));

        return true;
    }
}
