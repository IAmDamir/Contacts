import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern program = Pattern.compile("[a-z]*program[a-z]*", Pattern.CASE_INSENSITIVE);
        Matcher textProgram = program.matcher(text);
        while (textProgram.find()) {
            System.out.println(textProgram.start() + " " + textProgram.group());
        }
    }
}