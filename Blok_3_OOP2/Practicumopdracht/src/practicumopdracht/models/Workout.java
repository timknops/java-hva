package practicumopdracht.models;

import java.time.LocalDate;

public class Workout {

    private String name;
    private LocalDate date;
    private boolean completed;

    public Workout(String name, LocalDate date, boolean completed) {
        this.name = name;
        this.date = date;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("Naam: %s | Datum: %s | Afgerond: %s", name, date, completed ? "ja" : "nee");
    }
}
