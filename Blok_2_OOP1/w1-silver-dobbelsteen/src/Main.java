public class Main {

    public static void main(String[] args) {
        Dobbelsteen steen = new Dobbelsteen();
        System.out.println(steen.getWorp());
        steen.gooi();
        steen.print();

        Dobbelsteen steenMetAnderOog = new Dobbelsteen('$');
        System.out.println(steenMetAnderOog.getWorp());
        steenMetAnderOog.gooi();
        steenMetAnderOog.print();
    }
}
