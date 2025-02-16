import java.sql.*;
import java.util.Scanner;

public class StudentUpdate {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET name = ?, department = ?, marks = ? WHERE id = ?");
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();

            System.out.print("Enter New Name: ");
            String name = sc.next();

            System.out.print("Enter New Department: ");
            String dept = sc.next();

            System.out.print("Enter New Marks: ");
            double marks = sc.nextDouble();

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, marks);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) 
                System.out.println("Updated successfully!");
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
