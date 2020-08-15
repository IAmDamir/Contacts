import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern bigNum = Pattern.compile("\\d{10,}");
        Matcher bN = bigNum.matcher(stringWithNumbers);
        while (bN.find()) {
            int length = bN.end() - bN.start();
            System.out.println(bN.group() + ":" + length);
        }
    }
}