import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Program3 {
    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void main(String[] args) {
        try {
            readFile("C:\\Exceptional Handling\\sample.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
