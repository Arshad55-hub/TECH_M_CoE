import java.io.File;

public class Program4 {
    public static void main(String[] args) {
        File file = new File("C:\\IO_STREAMS\\example.txt");
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
