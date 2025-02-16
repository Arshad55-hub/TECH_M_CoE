import java.util.Arrays;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        
        System.out.println("equals(): " + Arrays.equals(arr1, arr2)); 
        System.out.println("Objects.equals(): " + Objects.equals(arr1, arr2)); 
        
        System.out.println("Objects.deepEquals(): " + Objects.deepEquals(arr1, arr2));

        
        Object[] nestedArr1 = {new int[]{1, 2}, new int[]{3, 4}};
        Object[] nestedArr2 = {new int[]{1, 2}, new int[]{3, 4}};

        System.out.println("Objects.equals(nested): " + Objects.equals(nestedArr1, nestedArr2)); 
        System.out.println("Objects.deepEquals(nested): " + Objects.deepEquals(nestedArr1, nestedArr2)); 
    }
}