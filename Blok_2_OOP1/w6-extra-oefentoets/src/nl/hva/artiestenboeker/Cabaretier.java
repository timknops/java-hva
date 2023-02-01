package nl.hva.artiestenboeker;

import java.time.LocalDate;

public class Cabaretier extends Artiest {

    private String voornaam;
    private String achternaam;
    private String artiestennaam;
    private LocalDate geboortedatum;

    public Cabaretier(String genre, String voornaam, String achternaam, String artiestennaam,
                      LocalDate geboortedatum) {
        super(genre);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.artiestennaam = artiestennaam;
        this.geboortedatum = geboortedatum;
    }

    public Cabaretier(String genre, String voornaam, String achternaam, LocalDate geboortedatum) {
        super(genre);
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.artiestennaam = "";
    }

    @Override
    public String krijgNaam() {
        if (artiestennaam.isBlank()) {
            return voornaam + " " + achternaam;
        } else {
            return artiestennaam;
        }
    }

    @Override
    public String toString() {
        return String.format("%s(%s), aantal boekingen: %d geboortedatum: %s",
                krijgNaam(), getGenre(), krijgAantalBoekingen(), geboortedatum);
    }
}
