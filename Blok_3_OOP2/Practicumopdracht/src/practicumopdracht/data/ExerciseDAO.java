package practicumopdracht.data;

import practicumopdracht.models.Exercise;
import practicumopdracht.models.Workout;

import java.util.ArrayList;
import java.util.List;

public abstract class ExerciseDAO implements DAO<Exercise> {

    protected List<Exercise> models;

    public ExerciseDAO() {
        models = new ArrayList<>();
    }

    public List<Exercise> getAllFor(Workout model) {
        List<Exercise> matchingExercisesList = new ArrayList<>();
        for (Exercise exercise : models) {
            if (exercise.getBelongsTo().equals(model)) {
                matchingExercisesList.add(exercise);
            }
        }

        return matchingExercisesList;
    }

    @Override
    public List<Exercise> getAll() {
        return models;
    }

    @Override
    public void addOrUpdate(Exercise model) {
        if (!models.contains(model)) {
            models.add(model);
        }
    }

    @Override
    public void remove(Exercise model) {
        models.remove(model);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
