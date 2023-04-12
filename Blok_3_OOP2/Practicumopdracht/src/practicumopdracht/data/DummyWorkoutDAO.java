package practicumopdracht.data;

import practicumopdracht.models.Workout;
import java.time.LocalDate;

public class DummyWorkoutDAO extends WorkoutDAO {

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        models.add(new Workout("Push", LocalDate.of(2023, 4, 30), false));
        models.add(new Workout("Full Body", LocalDate.now(), true));

        return true;
    }
}
