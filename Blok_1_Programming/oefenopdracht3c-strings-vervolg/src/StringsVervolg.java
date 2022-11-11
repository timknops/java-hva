import java.util.Scanner;

/**
 * Program asks for user input and gives info based on what the user gave.
 *
 * @author Tim Knops
 */

public class StringsVervolg {

    /**
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Geef een zin van 3 woorden: ");
        String firstSentence = input.nextLine();

        System.out.printf("Aantal karakters in de zin: %d\n", firstSentence.length());
        System.out.printf("Eerste letter van de zin: %c\n", firstSentence.charAt(0));

        // Splits the sentence in to words and stores them in an array and prints out the first word + sentence in UPPERCASE
        String[] firstSentenceWords = firstSentence.split(" ");
        System.out.printf("Eerste woord in de zin: %s\n", firstSentenceWords[0]);
        System.out.printf("De zin in hoofdletters: %s\n\n", firstSentence.toUpperCase());

        System.out.print("Geef een tweede zin van 3 woorden: ");
        String secondSentence = input.nextLine();

        // Splits the sentence in to words and prints out the amount of characters and first character in each word
        String[] secondSentenceWords = secondSentence.split(" ");
        for (int i = 0; i < secondSentenceWords.length; i++) {
            System.out.printf("Aantal karakters in woord %d: %d\n", i, secondSentenceWords[i].length());
        }
        for (int i = 0; i < secondSentenceWords.length; i++) {
            System.out.printf("De eerste letter van woord %d: %c\n", i, secondSentenceWords[i].charAt(0));
        }
        System.out.printf("De zin in hoofdletters: %s\n\n", secondSentence.toUpperCase());

        System.out.print("Geef een derde zin van drie woorden: ");
        String thirdSentence = input.nextLine();

        // Checks to see if the first string input is equal to the third string input
        if (firstSentence.equals(thirdSentence)) {
            System.out.println("Zin 3 is gelijk aan zin 1");
        } else {
            System.out.println("Zin 3 is niet gelijk aan zin 1");
        }

        // Checks the same thing as the previous if-else block, however it will overlook casing.
        if (firstSentence.equalsIgnoreCase(thirdSentence)) {
            System.out.println("Zin 3 is gelijk aan zin 1 als we hoofdletters negeren");
        } else {
            System.out.println("Zin 3 is ook niet gelijk aan zin 1 als we hoofdletters negeren");
        }

        // Splits the third sentence into words and stores it in an array,
        // then uses a nested for loop to iterate through both arrays to check if words match
        String[] thirdSentenceWords = thirdSentence.split(" ");
        for (String secondWord : secondSentenceWords) {
            boolean value = false;
            for (String thirdWord : thirdSentenceWords) {
                if (secondWord.equals(thirdWord)) {
                    value = true;
                    break;
                }
            }

            if (value) {
                System.out.printf("Het woord \"%s\" komt wel voor in zin 3\n", secondWord);
            } else {
                System.out.printf("Het woord \"%s\" komt niet voor in zin 3\n", secondWord);
            }
        }
    }
}
