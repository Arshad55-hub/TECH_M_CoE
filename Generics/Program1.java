class Program1 {
    public static <T> boolean arraysEqual(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        System.out.println(arraysEqual(arr1, arr2));

        String[] arr3 = {"B", "P", "V"};
        String[] arr4 = {"A", "J", "L"};
        System.out.println(arraysEqual(arr3, arr4));
    }
}
