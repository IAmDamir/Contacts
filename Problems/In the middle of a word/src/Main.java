import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        part = part.replaceAll(" ","");
        Pattern pattern = Pattern.compile("[a-zA-Z]+" + part + "[a-zA-Z]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean matches = matcher.find();
        if (matches) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}