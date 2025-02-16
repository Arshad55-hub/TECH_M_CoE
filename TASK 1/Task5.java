import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = sc.nextLine();
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                result += Character.toUpperCase(word.charAt(i));
            } else {
                result += Character.toLowerCase(word.charAt(i));
            }
        }

        System.out.println("Output: " + result);
        sc.close();
    }
}
