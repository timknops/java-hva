package nl.hva.leseenheid;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Superclass, bevat alle standaard informatie van een les.
 *
 * @author Tim Knops
 */

public class Leseenheid {

    protected String naam;
    protected int ects;
    protected int studiejaar;
    protected double ONDERGRENS_VOLDOENDE = 5.5;

    // Door middel van het gebruik maken van DecimalFormat, wordt het cijfer altijd naar het tweede decimaal afgerond.
    // Dus 5.49 word 5.4.
    protected final DecimalFormat df = new DecimalFormat("0.0");

    /**
     * Constructor.
     *
     * @param naam        naam van de leseenheid
     * @param ects        aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar  in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public Leseenheid(String naam, int ects, int studiejaar) {
        this.naam = naam;
        this.ects = ects;
        this.studiejaar = studiejaar;
        df.setRoundingMode(RoundingMode.DOWN); // Zorgt ervoor dat de 'rounding-mode' naar beneden afrond: 5.49 = 5.4;
    }

    /** Returns string waarde van leseenheid. */
    public String toString() {
        return naam + ", " + ects + " ects, studiejaar " + studiejaar;
    }
}
