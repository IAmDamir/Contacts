import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTime = scanner.nextLine();
        scanner.close();
        LocalDateTime dateTimePlusEleven = LocalDateTime.parse(dateTime).plusHours(11);
        LocalDate outputDate = dateTimePlusEleven.toLocalDate();
        System.out.println(outputDate);

    }
}
