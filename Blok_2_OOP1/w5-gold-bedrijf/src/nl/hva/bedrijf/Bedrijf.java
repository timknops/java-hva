package nl.hva.bedrijf;

import java.util.ArrayList;

public class Bedrijf {

    private String naam;
    private ArrayList<Persoon> medewerkers = new ArrayList<>();

    public Bedrijf(String naam) {
        this.naam = naam;
    }

    public void printInkomsten() {
        StringBuilder sb = new StringBuilder();

        System.out.println(medewerkers.size());
        sb.append("Inkomsten van alle personen:\n");
        for (int i = 0; i < medewerkers.size(); i++) {
            sb.append(String.format("\t\t%s, inkomsten: %.1f\n", medewerkers.get(i), 0.0));
        }

        System.out.println(sb);
    }

    public int aantalManagers() {
        return 0;
    }

    public void neemInDienst(Persoon persoon) {
        medewerkers.add(persoon);
    }

    public String toString() {
        return "";
    }
}
