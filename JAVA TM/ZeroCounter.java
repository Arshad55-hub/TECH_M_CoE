public class ZeroCounter {
    public static void main(String[] args) {
        int value = 25;
        int trailingZeroCount = 0;

        while (value > 0) {
            value /= 5;
            trailingZeroCount += value;
        }

        System.out.println("Number of trailing zeroes: " + trailingZeroCount);
    }
}
