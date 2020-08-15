import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        scanner.close();
        LocalDateTime startDate = LocalDateTime.of(dateTime.getYear(), 1, 1, 0, 0);
        System.out.println(startDate.until(dateTime, ChronoUnit.HOURS));
    }
}