import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Program11 {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("C:\\IO_STREAMS\\example.txt"));
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
