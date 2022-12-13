public class Pokemon {

    private String naam;
    private String type;
    private int hp;
    private Aanval[] aanvallen;

    public Pokemon(String naam, String type, int hp, Aanval[] aanvallen) {
        this.naam = naam;
        this.type = type;
        this.hp = hp;
        this.aanvallen = aanvallen;
    }

    public void printEigenschappen() {
        System.out.printf("%s, %s, %d", this.naam, this.type, this.hp);

        StringBuilder sb = new StringBuilder();

        for (Aanval aanval : this.aanvallen) {
            sb.append("\n\tnaam aanval: ");
            sb.append(aanval.getNaam());
            sb.append(", type: ");
            sb.append(aanval.getType());
            sb.append(", schade: ");
            sb.append(aanval.getSchade());
        }

        System.out.println(sb.toString());
    }
}
