import java.util.Scanner;
import java.time.LocalTime;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long seconds = scanner.nextLong();
        scanner.close();
        if (seconds != 0) {
            LocalTime time = LocalTime.ofSecondOfDay(seconds);
            System.out.println(time);
        }
    }
}