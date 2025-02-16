import java.sql.*;
import java.util.Scanner;

public class JDBCDDemo {
    private static final String URL = "jdbc:mysql://ARSH:3306/student_db";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in); Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            System.out.println("Connected to MySQL successfully!");
            while (true) {
                System.out.println("\n1. Insert  2. Update  3. Delete  4. Select  5. View All  6. Exit");
                int choice = scanner.nextInt();
                if (choice == 6) break;
                if (choice == 1) {
                    System.out.print("Enter ID: "); int id = scanner.nextInt();
                    System.out.print("Enter Name: "); String name = scanner.next();
                    stmt.executeUpdate("INSERT INTO students (id, name) VALUES (" + id + ", '" + name + "')");
                    System.out.println("Inserted!");
                } else if (choice == 2) {
                    System.out.print("Enter ID: "); int id = scanner.nextInt();
                    System.out.print("Enter New Name: "); String name = scanner.next();
                    stmt.executeUpdate("UPDATE students SET name='" + name + "' WHERE id=" + id);
                    System.out.println("Updated!");
                } else if (choice == 3) {
                    System.out.print("Enter ID: "); int id = scanner.nextInt();
                    stmt.executeUpdate("DELETE FROM students WHERE id=" + id);
                    System.out.println("Deleted!");
                } else if (choice == 4) {
                    System.out.print("Enter ID: "); int id = scanner.nextInt();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id=" + id);
                    if (rs.next()) System.out.println("ID: " + rs.getInt("id") + " Name: " + rs.getString("name"));
                    else System.out.println("No record found.");
                } else if (choice == 5) {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                    while (rs.next()) System.out.println("ID: " + rs.getInt("id") + " Name: " + rs.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
