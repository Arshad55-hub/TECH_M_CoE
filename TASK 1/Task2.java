import java.util.*;

class Student {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = (double) this.total / marks.length;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Total: " + total + ", Average: " + average;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the number of subjects: ");
            int subjects = scanner.nextInt();
            int[] marks = new int[subjects];

            System.out.println("Enter the marks:");
            for (int j = 0; j < subjects; j++) {
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine();

            students[i] = new Student(name, marks);
        }

        Arrays.sort(students, (s1, s2) -> s2.total - s1.total);

        System.out.println("\nStudent Details (Sorted by Total Marks):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
