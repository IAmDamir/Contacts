import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstTime = scanner.nextLine();
        String secondTime = scanner.nextLine();
        scanner.close();
        LocalTime time1 = LocalTime.parse(firstTime);
        LocalTime time2 = LocalTime.parse(secondTime);
        long secondsBetween = Math.abs(time1.toSecondOfDay() - time2.toSecondOfDay());
        System.out.println(secondsBetween);
    }
}