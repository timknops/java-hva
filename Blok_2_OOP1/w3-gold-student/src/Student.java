import java.time.LocalDate;

public class Student {

    private int studentnummer;
    private String voornaam;
    private String achternaam;
    private LocalDate geboortedatum;
    private Adres adres;

    public Student(int studentnummer, String voornaam, String achternaam, LocalDate geboortedatum, Adres adres) {
        this.studentnummer = studentnummer;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
    }

    public String toString() {
        return String.format("%d %s %s (%s)\nAdres: %s",
                studentnummer, voornaam, achternaam, krijgGeboortedatum(), adres.toString());
    }

    public String krijgGeboortedatum() {
        return String.valueOf(geboortedatum);
    }
}
