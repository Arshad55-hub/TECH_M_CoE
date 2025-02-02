public class TextProcessor {
    public static String reverseText(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static int countSubOccurrences(String source, String target) {
        int count = 0;
        int position = 0;
        while ((position = source.indexOf(target, position)) != -1) {
            count++;
            position += target.length();
        }
        return count;
    }

    public static String capitalizeWords(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String phrase = "hello world";
        System.out.println("Reversed: " + reverseText(phrase));
        System.out.println("Occurrences of 'l': " + countSubOccurrences(phrase, "l"));
        System.out.println("Capitalized: " + capitalizeWords(phrase));
    }
}
