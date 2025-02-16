import java.util.Iterator;
import java.util.LinkedList;

class Program14 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");
        Iterator<String> itr = list.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
