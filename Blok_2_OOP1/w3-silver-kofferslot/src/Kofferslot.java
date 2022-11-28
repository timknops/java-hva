public class Kofferslot {

    private Letter[] letterLijst = new Letter[2];
    private Cijfer cijfer;

    public Kofferslot() {
        this.cijfer = new Cijfer();
        this.letterLijst[0] = new Letter();
        this.letterLijst[1] = new Letter();
    }

    public Kofferslot(char eersteLetter, char tweedeLetter, int cijfer) {
        this.cijfer = new Cijfer();
        this.letterLijst[0] = new Letter();
        this.letterLijst[1] = new Letter();

        setCombinatie(eersteLetter, tweedeLetter, cijfer);
    }

    public void setCombinatie(char eersteLetter, char tweedeLetter, int cijfer) {
        letterLijst[0].setLetter(eersteLetter);
        letterLijst[1].setLetter(tweedeLetter);
        this.cijfer.setCijfer(cijfer);
    }

    public String volgende() {
        if (cijfer.getCijfer() == 9 && letterLijst[1].getLetter() == 'Z') {
            letterLijst[0].volgende();
            letterLijst[1].volgende();
        } else if (cijfer.getCijfer() == 9) {
            letterLijst[1].volgende();
        }

        cijfer.volgende();

        return String.format("%c%c%d\n", letterLijst[0].getLetter(), letterLijst[1].getLetter(), cijfer.getCijfer());
    }
}
