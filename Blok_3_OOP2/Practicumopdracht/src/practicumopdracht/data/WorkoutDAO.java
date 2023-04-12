package practicumopdracht.data;

import practicumopdracht.models.Workout;

import java.util.ArrayList;
import java.util.List;

public abstract class WorkoutDAO implements DAO<Workout> {

    protected List<Workout> models;

    public WorkoutDAO() {
        models = new ArrayList<>();
    }

    public Workout getById(int id) {
        if (models.contains(models.get(id))) {
            return models.get(id);
        }

        return null;
    }

    public int getIdFor(Workout model) {
        if (models.contains(model)) {
            return models.indexOf(model);
        }

        return -1;
    }

    @Override
    public List<Workout> getAll() {
        return models;
    }

    @Override
    public void addOrUpdate(Workout model) {
        if (!models.contains(model)) {
            models.add(model);
        }
    }

    @Override
    public void remove(Workout model) {
        models.remove(model);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
