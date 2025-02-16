import java.io.File;

public class Program1  {
    public static void main(String[] args) {
        
        String directoryPath = "C:\\IO_STREAMS";

        
        File folder = new File(directoryPath);

       
        if (folder.exists() && folder.isDirectory()) {
            
            String[] files = folder.list();

            
            if (files != null && files.length > 0) {
                System.out.println("Files and directories in: " + directoryPath);
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}
