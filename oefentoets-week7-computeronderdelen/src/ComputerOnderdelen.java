import java.util.Arrays;
import java.util.Scanner;


public class ComputerOnderdelen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MIN_AMOUNT_OF_PARTS = 1, MAX_AMOUNT_OF_PARTS = 25;

        System.out.println("Dit programma is gemaakt door Tim Knops, IS101, 500849389\n");

        System.out.print("Hoeveel computeronderdelen wil je verkopen? ");
        int amountOfParts = input.nextInt();

        while (amountOfParts < MIN_AMOUNT_OF_PARTS || amountOfParts > MAX_AMOUNT_OF_PARTS) {
            System.out.println("\tAantal onderdelen moet tussen de 1 en 25 liggen!");
            System.out.print("Hoeveel computeronderdelen wil je verkopen? ");
            amountOfParts = input.nextInt();
        }

        input.nextLine();

        String[] partNames = new String[amountOfParts];
        double[] partPrices = new double[amountOfParts];

        System.out.println("\nGeef voor elk onderdeel de omschrijving:");
        for (int i = 1; i <= partNames.length; i++) {
            System.out.printf("\t%d: ", i);
            partNames[i - 1] = input.nextLine();
        }

        System.out.println(Arrays.toString(partNames));

        System.out.println("\nGeef voor elk onderdeel de verkoopprijs: ");
        for (int i = 0; i < partPrices.length; i++) {
            System.out.printf("\tprijs %s: ", partNames[i]);
            partPrices[i] = input.nextDouble();
        }

        double totalPrice = calculateTotalPrice(partPrices);
        System.out.printf("\nDe totaalprijs van alle onderdelen bedraagt: %.1f\n", totalPrice);

        int salesPrice = calculateSalesPrices(totalPrice);
        System.out.printf("Hierover betaalt u aan verkoopkosten: %d \n", salesPrice);

        double totalProfit = totalPrice - salesPrice;
        System.out.printf("Indien alle onderdelen worden verkocht, ontvangt u: %.1f\n\n", totalProfit);

        System.out.println("Lijst van alle onderelen: ");
        for (int i = 0; i < amountOfParts; i++) {
            System.out.printf("%-30s %10.2f\n", partNames[i], partPrices[i]);
        }
    }

    public static double calculateTotalPrice(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }

        return total;
    }

    public static int calculateSalesPrices(double totalPrice) {
        final double SALES_PERCENTAGE = 5;
        final int MIN_RETURN = 3;

        double amount = totalPrice * (SALES_PERCENTAGE / 100);

        if (amount < MIN_RETURN) {
            return MIN_RETURN;
        }

        return (int) Math.round(amount);
    }
}
