import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> multiply = new ArrayList<>();
        int exception = 0;
        multiply.add(scanner.next());
        for (int i = 0; !"0".equals(multiply.get(i)); i++) {
            multiply.add(scanner.next());
        }
        do {
            try {
                for (; !"0".equals(multiply.get(exception)); exception++) {
                    System.out.println(Integer.parseInt(multiply.get(exception)) * 10);
                }
            } catch (Exception e) {
                System.out.println("Invalid user input: " + multiply.get(exception));
                exception++;
                for (; !"0".equals(multiply.get(exception)); exception++) {
                    System.out.println(Integer.parseInt(multiply.get(exception)) * 10);
                }
            }
        } while (!"0".equals(multiply.get(exception)));
    }
}