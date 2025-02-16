import java.io.File;

public class Program3 {
    public static void main(String[] args) {
        File file = new File("C:\\IO_STREAMS\\example.txt");
        System.out.println(file.exists() ? "Exists" : "Does not exist");
    }
}
