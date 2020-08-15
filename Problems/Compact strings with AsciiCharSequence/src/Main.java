import java.util.*;

class AsciiCharSequence implements CharSequence/* extends/implements */ {
    byte[] matrix;

    public AsciiCharSequence(byte[] matrix) {
        this.matrix = matrix.clone();
    }
    @Override
    public int length() {
        return matrix.length;
    }

    @Override
    public char charAt(int index) {
        return (char) matrix[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(matrix, start, end));
    }

    @Override
    public String toString() {
        return new String(matrix);
    }
    // implementation
}