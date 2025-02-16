import java.util.Scanner;

public class Employee {
    int id;
    String name;
    double salary;
    int years;

    public void setEmployeeDetails() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        id = scan.nextInt();
        scan.nextLine(); 
        System.out.print("Enter Employee Name: ");
        name = scan.nextLine();
        System.out.print("Enter Monthly Salary: ");
        salary = scan.nextDouble();
        System.out.print("Enter Years of Service: ");
        years = scan.nextInt();
        
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Monthly Salary: " + salary);
        System.out.println("Years of Service: " + years);
    }

    public void getLoanEligibility() {
        double annualSalary = salary * 12;
        if (years > 5) {
            if (annualSalary >= 1500000) {
                System.out.println("Eligible for loan: 7 lakhs");
            } else if (annualSalary >= 1000000) {
                System.out.println("Eligible for loan: 5 lakhs");
            } else if (annualSalary >= 600000) {
                System.out.println("Eligible for loan: 2 lakhs");
            } else {
                System.out.println("Not eligible for loan");
            }
        } else {
            System.out.println("Not eligible for loan - less than 5 years of service");
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmployeeDetails();
        emp.getEmployeeDetails();
        emp.getLoanEligibility();
    }
}
