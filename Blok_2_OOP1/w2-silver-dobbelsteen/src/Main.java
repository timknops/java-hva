public class Main {

    public static void main(String[] args) {
        Dobbelsteen steen1 = new Dobbelsteen('x');
        Dobbelsteen steen2 = new Dobbelsteen('x');

        gooiTotDubbel(steen1, steen2);
    }

    public static void gooiTotDubbel(Dobbelsteen dobbelsteen1, Dobbelsteen dobbelsteen2) {
        int count = 1;

        do {
            System.out.printf("\n---Ronde %d---\n", count);

            dobbelsteen1.gooi();
            dobbelsteen2.gooi();

            System.out.print("\nSteen 1:");
            dobbelsteen1.print();
            System.out.print("\nSteen 2:");
            dobbelsteen2.print();
            count++;
        } while ((dobbelsteen1.getWorp() != dobbelsteen2.getWorp()));

        System.out.println("\nDe stenen zijn gelijk!");
    }
}
