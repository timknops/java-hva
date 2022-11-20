public class Bankaccount {

    public static final int LIMIET_SALDO = 100_000;
    private String iban;
    private double saldo;

    public Bankaccount(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Ongeldig saldo opgegeven!");
        }
    }
}
