import java.io.File;
import java.util.Date;

public class Program6 {
    public static void main(String[] args) {
        File file = new File("C:\\IO_STREAMS\\example.txt");
        if (file.exists()) {
            System.out.println("Last Modified: " + new Date(file.lastModified()));
        } else {
            System.out.println("File not found.");
        }
    }
}
