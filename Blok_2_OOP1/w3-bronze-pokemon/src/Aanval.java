public class Aanval {

    private String naam;
    private String type;
    private int schade;

    public Aanval(String naam, String type, int schade) {
        this.naam = naam;
        this.type = type;
        this.schade = schade;
    }

    public String getNaam() {
        return naam;
    }

    public String getType() {
        return type;
    }

    public int getSchade() {
        return schade;
    }
}
