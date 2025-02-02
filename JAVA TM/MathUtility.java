package utility;

public class MathUtility {
    public static int getLength(int number) {
        return String.valueOf(number).length();
    }
}

// Usage in another class
import utility.MathUtility;

public class UtilityDemo {
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Length: " + MathUtility.getLength(number));
    }
} 