import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inpDate);
        System.out.println(date.minusYears(30));
        System.out.println(date.plusYears(30));
    }
}