import java.util.LinkedList;

class Program20 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("LEO");
        list.add("KANGUVA");
        list.add("VIDAMUYARCHI");
        System.out.println("First: " + list.indexOf("LEO"));
        System.out.println("Last: " + list.lastIndexOf("LEO"));
    }
}
