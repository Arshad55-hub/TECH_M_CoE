import java.io.File;

public class Program2 {
    public static void main(String[] args) {
        File folder = new File("C:\\IO_STREAMS");
        String[] files = folder.list((dir, name) -> name.endsWith(".txt"));
        if (files != null && files.length > 0) {
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("No .txt files found.");
        }
    }
}
