import java.util.*;

class Program5 {
public static void main(String[] args) {
List<String> names = Arrays.asList("apple","banana","kuwa","blue berry","amla");
long count = names.stream().filter(n->n.startsWith("a")).count();
System.out.println("Count of strings starting with 'a': "+count);
}
}
