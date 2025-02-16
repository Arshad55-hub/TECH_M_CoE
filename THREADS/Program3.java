import java.util.Arrays;

class SortThread extends Thread {
    int[] arr;

    SortThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

class Program3 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 4, 2, 6};
        SortThread t1 = new SortThread(arr);
        t1.start();
    }
}
