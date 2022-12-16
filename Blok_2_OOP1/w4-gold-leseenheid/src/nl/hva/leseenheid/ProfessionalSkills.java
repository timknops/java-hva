package nl.hva.leseenheid;

/**
 * Sub-Klasse van Leseenheid, bevat alle informatie van een Professional Skill, en of deze is gehaald of niet.
 *
 * @see Leseenheid
 * @author Tim Knops
 */

public class ProfessionalSkills extends Leseenheid {

    private boolean gehaald;

    /**
     * Constructor.
     *
     * @param gehaald     geeft aan of wel of niet is gehaald
     * @param naam        naam van de leseenheid
     * @param ects        aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar  in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public ProfessionalSkills(boolean gehaald, String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
        this.gehaald = gehaald;
    }

    /**
     * Constructor.
     *
     * @param naam        naam van de leseenheid
     * @param ects        aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar  in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public ProfessionalSkills(String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
    }

    /**
     * Veranderd of de professional skill is gehaald is of niet.
     *
     * @param gehaald geeft aan of wel of niet is gehaald
     */
    public void setGehaald(boolean gehaald) {
        this.gehaald = gehaald;
    }

    /** Returns true als de professional skill is gehaald, false als dit niet het geval is. */
    public boolean isAfgerond() {
        return gehaald;
    }

    /** Returns string waarde van ProfessionalSkills. */
    @Override
    public String toString() {
        String strGehaald = gehaald ? "gehaald" : "niet gehaald";
        return naam + ", " + ects + " ects, studiejaar " + studiejaar + ", " + strGehaald;
    }
}
