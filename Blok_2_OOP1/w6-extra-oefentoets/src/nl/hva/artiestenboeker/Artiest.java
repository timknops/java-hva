package nl.hva.artiestenboeker;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Artiest implements Comparable<Artiest> {

    private String genre;
    private ArrayList<LocalDate> boekingen;

    public Artiest(String genre) {
        this.genre = genre;
        this.boekingen = new ArrayList<>();
    }

    public abstract String krijgNaam();

    public int krijgAantalBoekingen() {
        return boekingen.size();
    }

    public boolean boek(LocalDate datum) {
        for (LocalDate boeking : boekingen) {
            if (boeking.equals(datum)) {
                return false;
            }
        }

        boekingen.add(datum);
        return true;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int compareTo(Artiest andereArtiest) {
        return this.getGenre().compareTo(andereArtiest.getGenre());
    }

    @Override
    public String toString() {
        return krijgNaam() + "(" + genre + "), aantal boekingen: " + krijgAantalBoekingen();
    }
}
