package nl.hva.registratiesysteem;

public class Student extends Persoon {

    private int studiepunten;

    public Student(String naam, String woonplaats, int studiepunten) {
        super(naam, woonplaats);
        this.studiepunten = studiepunten;
    }

    public boolean heeftGenoegStudiepunten() {
        return studiepunten >= 60;
    }

    public String toString() {
        String genoegStudiepunten = heeftGenoegStudiepunten() ? "genoeg studiepunten" : "niet genoeg studiepunten";

        return String.format("Student %s uit %s, heeft %d studiepunten, %s\n",
                this.naam, this.woonplaats, this.studiepunten, genoegStudiepunten);
    }
}
