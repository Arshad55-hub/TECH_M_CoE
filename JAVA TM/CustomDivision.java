public class CustomDivision {
    public static void main(String[] args) {
        int numerator = 25;
        int denominator = 5;
        int result = 0;
        int leftover = numerator;

        while (leftover >= denominator) {
            leftover -= denominator;
            result++;
        }

        System.out.println("Result: " + result);
        System.out.println("Leftover: " + leftover);
    }
}
