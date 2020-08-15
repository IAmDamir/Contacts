import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int column = 0; column < n; column++) {
            for (int row = 0; row < m; row++) {
                matrix[column][row] = scanner.nextInt();
            }
        }
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int valueI;
        scanner.close();
        for (int swapIAndJ = 0; swapIAndJ < n; swapIAndJ++) {
            valueI = matrix[swapIAndJ][i];
            matrix[swapIAndJ][i] = matrix[swapIAndJ][j];
            matrix[swapIAndJ][j] = valueI;
        }
        for (int column = 0; column < n; column++) {
            for (int row = 0; row < m; row++) {
                System.out.print(matrix[column][row] + " ");
            }
            System.out.println("");
        }
    }
}

