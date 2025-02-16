import java.util.*;

class Program2 {
public static void main(String[] args) {
List<String> words = Arrays.asList("java","python","c++","javascript");
List<String> upper = words.stream().map(s->s.toUpperCase()).toList();
List<String> lower = words.stream().map(s->s.toLowerCase()).toList();
System.out.println("Uppercase: "+upper);
System.out.println("Lowercase: "+lower);
}
}
