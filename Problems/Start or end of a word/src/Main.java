import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        scanner.close();
        Pattern pattern = Pattern.compile("\\A" + part + ".*|\\B*" + part +"\\Z", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean matches = matcher.matches();
        if (matches) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}