package nl.hva.bedrijf;

public class Manager extends Werknemer {

    private double bonus;

    public Manager(double maandsalaris, String naam) {
        super(maandsalaris, naam);
    }

    public void kenBonusToe(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double berekenInkomsten() {
        return getMaandsalaris() + bonus;
    }
}
