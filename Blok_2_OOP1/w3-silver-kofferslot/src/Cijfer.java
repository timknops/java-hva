public class Cijfer {

    private int cijfer;

    public Cijfer() {
        this.cijfer = 0;
    }

    public int getCijfer() {
        return cijfer;
    }

    public void setCijfer(int cijfer) {
        this.cijfer = cijfer;
    }

    public void volgende() {
        if (cijfer == 9) {
            cijfer = 0;
        } else {
            cijfer++;
        }
    }
}
