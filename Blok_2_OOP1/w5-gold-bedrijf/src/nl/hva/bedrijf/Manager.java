package nl.hva.bedrijf;

/**
 * Sub-class van Medewerker. Bevat alle standaard informatie van een manager. Unieke toevoeging is de methode
 * kenBonusToe, waarbij een manager een bonus kan worden gegeven.
 *
 * @see Werknemer
 * @author Tim Knops
 */

public class Manager extends Werknemer {

    private double bonus;

    /**
     * Constructor.
     *
     * @param maandsalaris  hoeveelheid dat een medewerker elke maand betaald krijgt
     * @param naam          naam van de medewerker
     */
    public Manager(double maandsalaris, String naam) {
        super(maandsalaris, naam);
    }

    /** Voegt een bonus toe aan de manager, verhoogd de inkomsten */
    public void kenBonusToe(double bonus) {
        this.bonus = bonus;
    }

    /** {@inheritDoc} Bevat ook de bonus. */
    @Override
    public double berekenInkomsten() {
        return getMaandsalaris() + bonus;
    }
}
