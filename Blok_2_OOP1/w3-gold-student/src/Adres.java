/**
 * In de Adres klas bevindt zich alle informatie van een adres van een student.
 *
 * @author Tim Knops
 */
public class Adres {

    private String straat;
    private int huisnummer;
    private String postcode;
    private String plaats;

    /**
     * Constructor.
     *
     * @param straat     de straatnaam van het adres
     * @param huisnummer het huisnummer van het adres
     * @param postcode   de postcode van hey adres
     * @param plaats     de plaats waar de student woont
     */
    public Adres(String straat, int huisnummer, String postcode, String plaats) {
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
    }

    /** Returns een geformatteerde string met alle adresinformatie. */
    public String toString() {
        return String.format("%s %d, %s %s\n", straat, huisnummer, postcode, plaats);
    }

    /**
     * Validatie voor de postcode. Door gebruik te maken van regex, wordt er gekeken of de postcode een geldig
     * Nederlands postcode is.
     *
     * @param  postcode de postcode die gevalideerd moet worden
     * @return true als de postcode geldig is, anders false
     */
    public static boolean isGeldigePostcode(String postcode) {
        String regex = "^[1-9](\\d){3}[A-Z]{2}$";

        return postcode.matches(regex);
    }
}
