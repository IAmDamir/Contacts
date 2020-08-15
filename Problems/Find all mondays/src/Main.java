import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        scanner.close();
        LocalDate date = LocalDate.of(year, month, 1);
        for (int i = 1; i < date.lengthOfMonth(); i++) {
            date = LocalDate.of(year, month, i);
            if (date.getDayOfWeek().toString().equals("MONDAY")) {
                System.out.println(date);
            }
        }
    }
}