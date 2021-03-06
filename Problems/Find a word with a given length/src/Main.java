import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Za-z]{" + size + "}\\b");
        Matcher matcher = pattern.matcher(line);
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
