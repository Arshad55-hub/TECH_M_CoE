import java.sql.*;
import java.util.Scanner;

public class StudentDelete {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id = ?");
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) 
                System.out.println("Deleted successfully!");
            else 
                System.out.println("Student ID not found.");

            ps.close();
            conn.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
