import java.time.LocalDate;

/**
 * Een student object bevat alle informatie van een enkele student, ook het adres.
 *
 * @author Tim Knops
 */
public class Student {

    private int studentnummer;
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;
    private Adres adres;

    /**
     * Constructor.
     *
     * @param studentnummer het studentnummer van een student
     * @param voornaam      de voornaam van een student
     * @param achternaam    de achtenaam van een student
     * @param geboortedatum de geboortedatum van een student
     * @param adres         een object van het adres van een student
     */
    public Student(int studentnummer, String voornaam, String achternaam, LocalDate geboortedatum, Adres adres) {
        this.studentnummer = studentnummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
    }

    /**
     * Maakt een string van alle studentinformatie.
     *
     * @return een string met alle studentinformatie
     */
    public String toString() {
        return String.format("%d %s %s (%s)\nAdres: %s",
                studentnummer, voornaam, achternaam, krijgGeboortedatum(), adres.toString());
    }

    /** Returns de string waarde van de geboortedatum. */
    public String krijgGeboortedatum() {
        return String.valueOf(geboortedatum);
    }
}
