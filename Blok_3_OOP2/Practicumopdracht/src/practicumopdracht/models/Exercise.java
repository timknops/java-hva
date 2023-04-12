package practicumopdracht.models;

import java.io.Serializable;

/**
 *
 */
public class Exercise implements Serializable {

    private transient Workout belongsTo;
    private String name;
    private int sets;
    private int reps;
    private double weight;
    private String notes;
    private int rateOfPerceivedExertion;

    public Exercise(Workout belongsTo, String name, int sets, int reps, double weight, String notes, int rateOfPerceivedExertion) {
        this.belongsTo = belongsTo;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
        this.rateOfPerceivedExertion = rateOfPerceivedExertion;
    }

    public Workout getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Workout belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRateOfPerceivedExertion() {
        return rateOfPerceivedExertion;
    }

    public void setRateOfPerceivedExertion(int rateOfPerceivedExertion) {
        this.rateOfPerceivedExertion = rateOfPerceivedExertion;
    }

    @Override
    public String toString() {
        String result = String.format("Naam: %s\nSets: %s | Reps: %s | Gewicht: %s | RPE: %s\nNotities: %s",
                name, sets, reps, weight, rateOfPerceivedExertion, notes == null ? "" : notes);

        if (notes == null) {
            return result.replace("Notities: ", "");
        }

        return result;
    }
}
