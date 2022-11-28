public class Letter {

    private char letter;

    public Letter() {
        this.letter = 'A';
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void volgende() {
        if (letter == 'Z') {
            letter = 'A';
        } else {
            letter++;
        }
    }
}
