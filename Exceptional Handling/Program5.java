import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Program5 {
    public static void checkEmptyFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        if (!sc.hasNextLine()) {
            throw new IllegalArgumentException("File is empty");
        }
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void main(String[] args) {
        try {
            checkEmptyFile("C:\\Exceptional Handling\\data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
