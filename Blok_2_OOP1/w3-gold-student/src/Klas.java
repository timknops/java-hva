public class Klas {

    private String naam;
    private int aantalStudenten;
    private Student[] studenten;

    public Klas(String naam) {
        this.naam = naam;
        this.studenten = new Student[3];
        this.aantalStudenten = 0;
    }

    public boolean voegStudentToe(Student student) {
        final int MAX_AANTAL_STUDENTEN = studenten.length;
        if (aantalStudenten < MAX_AANTAL_STUDENTEN) {
            studenten[aantalStudenten] = student;
            aantalStudenten++;
            return true;
        } else {
            return false;
        }
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(String.format("Klas: %s (%d studenten)\n",
                naam, aantalStudenten));
        for (int i = 0; i < aantalStudenten; i++) {
            str.append(studenten[i].toString());
        }

        return str.toString();
    }
}
