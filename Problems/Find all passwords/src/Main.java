import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern password = Pattern.compile("password:? *([a-z0-9]+)[. ]?", Pattern.CASE_INSENSITIVE);
        Matcher textPass = password.matcher(text);
        int i = 0;
        for (;textPass.find(); i++) {
            System.out.println(textPass.group(1));
        }
        if (i == 0) {
            System.out.println("No passwords found.");
        }
    }
}