/**
 * Een klas object bevat alle studenten en adressen van de student die zich in een klas bevinden.
 *
 * @author Tim Knops
 */
public class Klas {

    private String naam;
    private int aantalStudenten;
    private Student[] studenten;

    /**
     * Constructor.
     *
     * @param naam de naam van de klas
     */
    public Klas(String naam) {
        this.naam = naam;
        this.studenten = new Student[30];
        this.aantalStudenten = 0;
    }

    /**
     * Voegt een student toe aan de studenten array.
     *
     * @param student de student die wordt toegevoegd aan de klas
     * @return        true als er nog ruimte over is in de klas, false als de klas vol is
     */
    public boolean voegStudentToe(Student student) {
        final int MAX_AANTAL_STUDENTEN = studenten.length;
        if (aantalStudenten < MAX_AANTAL_STUDENTEN) {
            studenten[aantalStudenten] = student;
            aantalStudenten++;
            return true;
        } else {
            return false;
        }
    }

    /** Returns hoeveelheid student die momenteel in de klas zitten. */
    public int getAantalStudenten() {
        return aantalStudenten;
    }

    /**
     * Maakt een string van alle studenten die in de klas zitten.
     *
     * @return string van alle studenten die in de klas zitten, met alle informatie van elke student
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(String.format("Klas: %s (%d studenten)\n", naam, aantalStudenten));
        for (int i = 0; i < aantalStudenten; i++) {
            str.append(studenten[i].toString());
        }

        return str.toString();
    }
}
