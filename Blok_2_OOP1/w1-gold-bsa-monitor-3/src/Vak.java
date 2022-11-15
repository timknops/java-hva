/**
 * Vak is de basis class waarbij de gebruiker alle informatie te zien
 * krijgt over het desbetreffende vak.
 *
 * @author Tim Knops
 */
public class Vak {

    private final String NAAM;
    private int punten;
    private double cijfer;

    /**
     * Constructor.
     *
     * @param naam      naam van het vak
     * @param punten    het totaal aantal punten dat wordt behaald wanneer het cijfer
     *                  hoog genoeg is
     */
    public Vak(String naam, int punten) {
        this.NAAM = naam;
        this.punten = punten;
    }

    /** @return naam gegeven in de constructor */
    public String getNaam() {
        return NAAM;
    }

    /** @return punten gegeven in constructor */
    public int getPunten() {
        return punten;
    }

    /** @return cijfer gegeven in de constructor */
    public double getCijfer() {
        return cijfer;
    }

    /**
     * Zet het cijfer in de constructor gelijk aan de door de gebruiker behaalde cijfer.
     *
     * @param nieweCijfer   het cijfer behaald door de gebruiker
     */
    public void setCijfer(double nieweCijfer) {
        this.cijfer = nieweCijfer;
    }

    /** @return het aantal punten behaald door de gebruiker afhankelijk van hoe hoog het cijfer is. */
    public int gehaaldePunten() {
        if (cijfer < 5.5) {
            punten = 0;
        }

        return punten;
    }
}
