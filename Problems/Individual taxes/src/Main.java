import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double[] incomes = new double[N];
        for (int i = 0; i < N; i++) {
            incomes[i] = scanner.nextDouble();
        }
        double[] taxes = new double[N];
        for (int i = 0; i < N; i++) {
            taxes[i] = scanner.nextDouble();
        }
        scanner.close();
        double maxTax = 0, curTax;
        int comNum = 0;
        for (int i = 0; i < N; i++) {
            curTax = taxes[i]*incomes[i] / 100;
            if (curTax > maxTax) {
                maxTax = curTax;
                comNum = i + 1;
            }
            if (i == N - 1) {
                System.out.println(comNum);
            }
        }
    }
}