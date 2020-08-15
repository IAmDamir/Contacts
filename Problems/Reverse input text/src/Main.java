import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        string = string.trim();
        for (int i = 1; i < string.length() + 1; i++) {
            char chars = string.charAt(string.length() - i);
            System.out.print(chars);
        }
        reader.close();
    }
}