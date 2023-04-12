package practicumopdracht.comparators;

import practicumopdracht.models.Exercise;
import java.util.Comparator;

public class NameComparator implements Comparator<Exercise> {

    private boolean sortDescending;

    public NameComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    @Override
    public int compare(Exercise exercise1, Exercise exercise2) {
        return exercise1.getName().toLowerCase().compareTo(exercise2.getName().toLowerCase());
    }

    public boolean isSortDescending() {
        return sortDescending;
    }
}
