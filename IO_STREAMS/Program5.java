import java.io.File;

public class Program5 {
    public static void main(String[] args) {
        File file = new File("C:\\IO_STREAMS\\example.txt");
        System.out.println(file.isFile() ? "File" : "Directory");
    }
}
