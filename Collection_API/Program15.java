import java.util.LinkedList;

class Program15 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");
        System.out.println(list);
    }
}
