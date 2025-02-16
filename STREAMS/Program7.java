import java.util.*;

class Program7 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(5,2,9,1,7);
int max = numbers.stream().max(Integer::compare).orElse(-1);
int min = numbers.stream().min(Integer::compare).orElse(-1);
System.out.println("Maximum: "+max);
System.out.println("Minimum: "+min);
}
}
