package practicumopdracht.comparators;

import practicumopdracht.models.Exercise;
import java.util.Comparator;

public class VolumeComparator implements Comparator<Exercise> {

    private boolean sortDescending;

    public VolumeComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    @Override
    public int compare(Exercise exercise1, Exercise exercise2) {
        int volumeCompare = (exercise1.getReps() * exercise1.getSets()) - (exercise2.getReps() * exercise2.getSets());
        if (volumeCompare != 0) {
            return volumeCompare;
        }

        return exercise1.getName().toLowerCase().compareTo(exercise2.getName().toLowerCase());
    }

    public boolean isSortDescending() {
        return sortDescending;
    }
}
