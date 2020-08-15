import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if (!string.trim().isEmpty()) {
            String[] splitted = string.trim().split("\\s+");
            System.out.println(splitted.length);
            reader.close();
        } else {
            System.out.println(0);
        }
    }
}