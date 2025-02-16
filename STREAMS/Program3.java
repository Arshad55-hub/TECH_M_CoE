import java.util.*;

class Program3 {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
int evenSum = numbers.stream().filter(n->n%2==0).mapToInt(n->n).sum();
int oddSum = numbers.stream().filter(n->n%2!=0).mapToInt(n->n).sum();
System.out.println("Even sum: "+evenSum);
System.out.println("Odd sum: "+oddSum);
}
}
