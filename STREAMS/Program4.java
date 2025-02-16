import java.util.*;

class Program4 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1,2,2,3,4,4,5);
List<Integer> distinct = numbers.stream().distinct().toList();
System.out.println("Distinct Numbers: "+distinct);
}
}
