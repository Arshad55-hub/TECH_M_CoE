import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMENU:");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View Student");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> insertStudent(conn, sc);
                    case 2 -> updateStudent(conn, sc);
                    case 3 -> deleteStudent(conn, sc);
                    case 4 -> viewStudent(conn, sc);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option! Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        String query = "INSERT INTO students (name, department, marks) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Department: ");
            String dept = sc.next();
            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, marks);

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Student inserted successfully!");
        }
    }

    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        String query = "UPDATE students SET name = ?, department = ?, marks = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
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
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student ID not found.");
        }
    }

    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student ID not found.");
        }
    }

    private static void viewStudent(Connection conn, Scanner sc) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            System.out.print("Enter Student ID to view: ");
            int id = sc.nextInt();

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   ", Name: " + rs.getString("name") +
                                   ", Dept: " + rs.getString("department") +
                                   ", Marks: " + rs.getDouble("marks"));
            } else {
                System.out.println("Student ID not found.");
            }
        }
    }
}
