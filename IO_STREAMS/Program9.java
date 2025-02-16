import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Program9 {
    public static void main(String[] args) {
        File file = new File("C:\\IO_STREAMS\\example.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            String content = new String(data);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
