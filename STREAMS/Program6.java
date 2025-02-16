import java.util.*;

class Program6 {
public static void main(String[] args) {
List<String> words = Arrays.asList("leo","kanguva","valimai","retro");
List<String> ascending = words.stream().sorted().toList();
List<String> descending = words.stream().sorted(Comparator.reverseOrder()).toList();
System.out.println("Ascending order: "+ascending);
System.out.println("Descending order: "+descending);
}
}
