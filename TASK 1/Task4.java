import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {

        int[] nums = {5, 10, 15, 20, 25, 30, 35};
        int[] newNums = Arrays.copyOfRange(nums, 1, 4);

        
        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Copied Array (index 1 to 3): " + Arrays.toString(newNums));
    }
}
