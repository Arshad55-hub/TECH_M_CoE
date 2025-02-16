import java.util.*;

class Program1 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(10,20,30,40,50);
double avg = numbers.stream().mapToInt(n -> n).average().orElse(0.0);
System.out.println("Average: " + avg);
}
}
