import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Adres adres = new Adres("hans", 10, "1625GH", "Hoorn");
        Student student = new Student(500849389,
                "Hans", "Klok", LocalDate.of(2001, 1, 13), adres);

        System.out.println(student.toString());




    }
}
