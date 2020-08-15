import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.close();
        LocalDate date = LocalDate.ofYearDay(year, day);
        boolean lastDay = date.getDayOfMonth() == date.lengthOfMonth();
        if (lastDay) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}