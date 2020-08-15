import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        scanner.close();
        String first = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        int checker = 256;
        boolean yn = false;
        if (ip.matches(first)) {
            String[] splitter = ip.split("\\.", 4);
            for (int i = 0; i < 4; i++) {
                if (Integer.parseInt(splitter[i]) < checker && Integer.parseInt(splitter[i]) > -1) {
                    yn = true;
                } else {
                    yn = false;
                    break;
                }
            }
        }
        if (yn) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}