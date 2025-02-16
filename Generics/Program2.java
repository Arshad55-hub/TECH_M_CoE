import java.util.List;

class Program2 {
    public static <T extends Number> void sumEvenOdd(List<T> list) {
        int evenSum = 0, oddSum = 0;
        for (T num : list) {
            int n = num.intValue();
            if (n % 2 == 0) evenSum += n;
            else oddSum += n;
        }
        System.out.println("Even sum: " + evenSum + ", Odd sum: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        sumEvenOdd(nums);
    }
}
