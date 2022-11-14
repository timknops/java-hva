/**
 *
 *
 * @author Tim Knops
 */

public class Main {

    public static void main(String[] args) {
        Film film = new Film("Titanic", 220, 9);

        System.out.printf("Film: %s duur: %dm beoordeling: %d.\n",
                film.titel, film.duur, film.beoordeling);

        film.afspelen();
        film.pauzeren();
        film.stoppen();
    }
}
