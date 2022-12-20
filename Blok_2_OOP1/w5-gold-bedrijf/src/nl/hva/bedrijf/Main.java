package nl.hva.bedrijf;

public class Main {

    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf("HvA");

        Manager manager = new Manager(10000, "Peter");
        Manager manager1 = new Manager(10000, "Peter1");
        Manager manager2 = new Manager(10000, "Peter2");

        bedrijf.neemInDienst(manager);
        bedrijf.neemInDienst(manager1);
        bedrijf.neemInDienst(manager2);

        bedrijf.printInkomsten();
    }
}
