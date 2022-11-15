public class Film {

    String titel;
    int duur;
    int beoordeling;

    public Film(String titel, int duur, int beoordeling) {
        this.titel = titel;
        this.duur = duur;
        this.beoordeling = beoordeling;
    }

    public void afspelen() {
        System.out.printf("Film: %s starten.\n", titel);
    }

    public void pauzeren() { System.out.printf("Film: %s is gepauzeerd.\n", titel); }

    public void stoppen() { System.out.printf("Film: %s is gestopt.\n", titel); }
}
