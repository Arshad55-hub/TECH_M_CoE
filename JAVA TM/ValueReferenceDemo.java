public class ValueReferenceDemo {
    public static void main(String[] args) {
        int value = 10;
        int[] numbers = {1, 2, 3};

        modifyValues(value, numbers);

        System.out.println("Primitive Value: " + value); // Passed by value
        System.out.print("Array Values: ");
        for (int item : numbers) {
            System.out.print(item + " "); // Passed by reference
        }
    }

    public static void modifyValues(int num, int[] arr) {
        num = 20;
        arr[0] = 100;
    }
}
