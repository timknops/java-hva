/**
 *
 *
 * @author Tim Knops
 */

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fullSentence;
        int sentenceLength;

        System.out.print("Geef een zin van 3 woorden: ");
        fullSentence = input.nextLine();

        System.out.printf("Aantal karakters in de zin: %d\n", fullSentence.length());
        System.out.printf("Eerste karakter in de zin: %c\n", fullSentence.charAt(0));

        String[] firstWord = fullSentence.split(" ", 1);
        System.out.printf("Eerste woord in de zin: %s\n", firstWord[0]);

    }
}
