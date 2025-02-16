import java.util.ArrayList;

class Program9 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Red");
        list1.add("Blue");

        ArrayList<String> list2 = new ArrayList<>(list1);
        System.out.println(list2);
    }
}
