import java.util.LinkedList;

class Program12 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        for (String item : list) {
            System.out.println(item);
        }
    }
}
