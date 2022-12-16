package nl.hva.leseenheid;

/**
 * Sub-Klasse van Leseenheid. Bevat een individueel vak met een cijfer.
 *
 * @see Leseenheid
 * @author Tim Knops
 */

public class Vak extends Leseenheid {

    private double cijfer;

    /**
     * Constructor.
     *
     * @param cijfer      cijfer dat voor dit vak is gehaald
     * @param naam        naam van de leseenheid
     * @param ects        aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar  in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public Vak(double cijfer, String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
        this.cijfer = cijfer;
    }

    /**
     * Constructor.
     *
     * @param naam        naam van de leseenheid
     * @param ects        aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar  in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public Vak(String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
    }

    /**
     * Veranderd het cijfer die voor het vak is gehaald.
     *
     * @param cijfer cijfer dat voor dit vak is gehaald.
     */
    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }

    /** Returns true als het cijfer hoger of gelijk aan de ONDERGRENS_VOLDOENDE is, anders false */
    public boolean isAfgerond() {
        return cijfer >= ONDERGRENS_VOLDOENDE;
    }

    /** Returns string waarde van Vak */
    @Override
    public String toString() {
        return naam + ", " + ects + " ects, studiejaar " + studiejaar + ", cijfer " + df.format(cijfer);
    }
}
