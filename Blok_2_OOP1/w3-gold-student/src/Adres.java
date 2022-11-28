public class Adres {

    private String straat;
    private int huisnummer;
    private String postcode;
    private String plaats;

    public Adres(String straat, int huisnummer, String postcode, String plaats) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
    }

    public String toString() {
        return String.format("%s %d, %s %s\n", straat, huisnummer, postcode, plaats);
    }

    public static boolean isGeldigePostcode(String postcode) {
        String regex = "^[1-9](\\d){3}[A-Z]{2}$";

        return postcode.matches(regex);
    }
}
