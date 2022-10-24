import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class GetallenRaden {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] randomArray = generateNumbers();
        System.out.println(Arrays.toString(randomArray));

        boolean correct = false;
        int guessNum;
        do {
            System.out.print("Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spatie: ");
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            int num3 = input.nextInt();



            correct = true;

        } while (!correct);


    }

    public static int[] generateNumbers() {
        Random rand = new Random();
        int ARRAY_LENGTH = 3, MIN_ARRAY_NUM = 1, MAX_ARRAY_NUM = 10;
        int[] guessArray = new int[ARRAY_LENGTH];

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            guessArray[i] = rand.nextInt(MIN_ARRAY_NUM, MAX_ARRAY_NUM);
        }

        return guessArray;
    }

    public static boolean correctGuess(int searchNum, int[] array) {
        for (int nums : array) {
            if (searchNum == nums) {
                return true;
            }
        }

        return false;
    }
}
