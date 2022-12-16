package nl.hva.leseenheid;

/**
 * Sub-Klasse van Leseenheid. Bevat ook cijfers voor het product, proces en het cijfer van M&T.
 *
 * @see Leseenheid
 * @author Tim Knops
 */

public class Project extends Leseenheid {

    private double productcijfer;
    private double procescijfer;
    private double methodenEnTechniekenCijfer;

    /**
     * Constructor.
     *
     * @param productcijfer              het cijfer voor de productbeoordeling
     * @param procescijfer               het cijfer voor de procesbeoordeling
     * @param methodenEnTechniekenCijfer het cijfer voor de M&T beoordeling
     * @param naam                       naam van de leseenheid
     * @param ects                       aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar                 in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegeven
     */
    public Project(double productcijfer, double procescijfer, double methodenEnTechniekenCijfer, String naam,
                   int ects, int studiejaar) {
        super(naam, ects, studiejaar);
        this.productcijfer = productcijfer;
        this.procescijfer = procescijfer;
        this.methodenEnTechniekenCijfer = methodenEnTechniekenCijfer;
    }

    /**
     * Constructor.
     *
     * @param naam       naam van de leseenheid
     * @param ects       aantal ects dat je met deze leseenheid kan halen
     * @param studiejaar in welk studiejaar (1, 2, 3 of 4) deze leseenheid wordt gegevenar
     */
    public Project(String naam, int ects, int studiejaar) {
        super(naam, ects, studiejaar);
    }

    /**
     * Veranderd het cijfer voor product.
     *
     * @param productcijfer het cijfer voor de productbeoordeling
     */
    public void setProductcijfer(double productcijfer) {
        this.productcijfer = productcijfer;
    }

    /**
     * Veranderd het cijfer voor proces.
     *
     * @param procescijfer het cijfer voor de procesbeoordeling
     */
    public void setProcescijfer(double procescijfer) {
        this.procescijfer = procescijfer;
    }

    /**
     * Veranderd het cijfer voor M&T.
     *
     * @param methodenEnTechniekenCijfer het cijfer voor de M&T beoordeling
     */
    public void setMethodenEnTechniekenCijfer(double methodenEnTechniekenCijfer) {
        this.methodenEnTechniekenCijfer = methodenEnTechniekenCijfer;
    }

    /** Returns true als alle cijfers gelijk, of boven de ONDERGRENS_VOLDOENDE zijn, anders false. */
    public boolean isAfgerond() {
        return  productcijfer >= ONDERGRENS_VOLDOENDE &&
                procescijfer >= ONDERGRENS_VOLDOENDE &&
                methodenEnTechniekenCijfer >= ONDERGRENS_VOLDOENDE;
    }

    /** Return een geformatte string waarde van Project */
    @Override
    public String toString() {
        return String.format("%s, %d ects, studiejaar %d (%s, %s, %s)",
                naam, ects, studiejaar, df.format(productcijfer), df.format(procescijfer),
                df.format(methodenEnTechniekenCijfer));
    }
}

