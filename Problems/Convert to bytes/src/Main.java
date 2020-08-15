import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte bytes = (byte) inputStream.read();
        while (bytes != -1) {
            System.out.print(bytes);
            bytes = (byte) inputStream.read();
        }
        inputStream.close();
    }
}