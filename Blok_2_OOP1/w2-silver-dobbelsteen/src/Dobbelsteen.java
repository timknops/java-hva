import java.util.Random;

public class Dobbelsteen {

    private int worp;
    private char karakter;
    private static Random getalGenerator = new Random();

    public Dobbelsteen() { }

    public Dobbelsteen(char karakter) {
        this.karakter = karakter;
    }

    public void gooi() {
        worp = getalGenerator.nextInt(6) + 1;
    }

    public void print() {
        switch (worp) {
            case 1 -> {
                System.out.printf("\n   \n %c \n   \n",
                        karakter);
            }
            case 2 -> {
                System.out.printf("\n%c  \n   \n  %c\n",
                        karakter, karakter);
            }
            case 3 -> {
                System.out.printf("\n%c  \n %c \n  %c\n",
                        karakter, karakter, karakter);
            }
            case 4 -> {
                System.out.printf("\n%c %c\n   \n%c %c\n",
                        karakter, karakter, karakter, karakter);
            }
            case 5 -> {
                System.out.printf("\n%c %c\n %c \n%c %c\n",
                        karakter, karakter, karakter, karakter, karakter);
            }
            case 6 -> {
                System.out.printf("\n%c %c\n%c %c\n%c %c\n",
                        karakter, karakter, karakter, karakter, karakter, karakter);
            }
        }
    }

    public int getWorp() {
        return worp;
    }
}
