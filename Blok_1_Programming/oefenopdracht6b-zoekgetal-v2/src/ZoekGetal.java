import java.util.Scanner;

public class ZoekGetal {

    public static void main(String[] args) {
        final int MIN_LENGTH = 5, MAX_LENGTH = 25, MIN_SEARCH = 0, MAX_SEARCH = 9;

        int arrayLength = getLength(MIN_LENGTH, MAX_LENGTH);
        int[] array = generateArray(arrayLength);

        printArray(array);
        searchInArray(array, MIN_SEARCH, MAX_SEARCH);
    }

    private static int getLength(int min, int max) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Hoe groot moet de array zijn (%d..%d)? ", min, max);
        int arrayLength = input.nextInt();

        while (arrayLength < min || arrayLength > max) {
            System.out.printf("De grootte moet tussen %d en %d liggen! Doe nog een poging.\n", min, max);
            System.out.printf("Hoe groot moet de array zijn (%d..%d)? ", min, max);
            arrayLength = input.nextInt();
        }

        return arrayLength;
    }

    private static int[] generateArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * (10));
        }

        return array;
    }

    private static void printArray(int[] array) {
        System.out.println();
        for (int arr : array) {
            System.out.printf("%d ", arr);
        }

        System.out.println();
    }

    private static void searchInArray(int[] array, int min, int max) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Welk zoekgetal moet ik zoeken (%d..%d)? ", min, max);
        int searchNumber = input.nextInt();

        while (searchNumber < min || searchNumber > max) {
            System.out.printf("Het zoekgetal moet tussen %d en %d liggen! Doe nog een poging.\n", min, max);
            System.out.printf("Welk zoekgetal moet ik zoeken (%d..%d)? ", min, max);
            searchNumber = input.nextInt();
        }

        int count = 0;
        for (int arr : array) {
            if (arr == searchNumber) {
                count++;
            }
        }

        double percentageOfNumber = (double) array.length / count;

        System.out.printf("\nHet getal %d komt %d keer voor in de lijst.\n", searchNumber, count);
        System.out.printf("Dat betekend dat %.1f%% van de getallen in de array gelijk is aan %d.\n", percentageOfNumber, searchNumber);
    }
}
