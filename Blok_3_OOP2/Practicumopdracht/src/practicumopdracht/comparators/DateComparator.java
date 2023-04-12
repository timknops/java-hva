package practicumopdracht.comparators;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Workout;

import java.util.Collections;
import java.util.Comparator;

public class DateComparator implements Comparator<Workout> {

    private boolean sortDescending;

    public DateComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    @Override
    public int compare(Workout workout1, Workout workout2) {
        return workout1.getDate().compareTo(workout2.getDate());
    }

    public void reverseIfDescending() {
        if (sortDescending) {
            Collections.reverse(MainApplication.getWorkoutDAO().getAll());
        }
    }
}
