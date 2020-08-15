import java.util.Scanner;
import java.time.LocalTime;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        scanner.close();
        LocalTime withoutSeconds = LocalTime.parse(time).withSecond(0);
        System.out.println(withoutSeconds);
    }
}