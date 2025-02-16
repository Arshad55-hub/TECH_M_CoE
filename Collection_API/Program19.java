import java.util.LinkedList;
import java.util.List;

class Program19 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("D");
        list.addAll(1, List.of("B", "C"));
        System.out.println(list);
    }
}
