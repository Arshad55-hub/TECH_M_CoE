import java.sql.*;
import java.util.Scanner;

public class StudentInsert {

    public static void insertRecords(Connection conn, PreparedStatement ps, Scanner sc, int count) throws SQLException {
        if (count == 0) return;

        System.out.print("Enter Student Name: ");
        String name = sc.next();

        System.out.print("Enter Department: ");
        String dept = sc.next();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        ps.setString(1, name);
        ps.setString(2, dept);
        ps.setDouble(3, marks);
        ps.executeUpdate();

        System.out.println("Inserted successfully!");

        insertRecords(conn, ps, sc, count - 1);
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, department, marks) VALUES (?, ?, ?)");
            Scanner sc = new Scanner(System.in);

            System.out.print("How many students to add? ");
            int numRows = sc.nextInt();

            insertRecords(conn, ps, sc, numRows);

            ps.close();
            conn.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
