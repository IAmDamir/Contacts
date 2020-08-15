import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> line = new ArrayList<>();
        String[] nums = scanner.nextLine().split(" ", 0);
        for (String num : nums) {
            line.add(Integer.parseInt(num));
        }
        int number = scanner.nextInt();
        scanner.close();
        int n = Integer.MAX_VALUE;
        for (Integer integer : line) {
            if (Math.abs(integer - number) < n) {
                n = Math.abs(integer - number);
            }
        }
        Collections.sort(line);
        if (line.lastIndexOf(number - n) != -1) {
            for (int i = line.indexOf(number - n) - 1; i < line.lastIndexOf(number - n); i++) {
                System.out.print(number - n + " ");
            }
        }
        if (line.lastIndexOf(number + n) != -1 && n != 0) {
            for (int i = line.indexOf(number + n) - 1; i < line.lastIndexOf(number + n); i++) {
                System.out.print(number + n + " ");
            }
        }
    }
}
