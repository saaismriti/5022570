package employees;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations management = new Operations(50);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String addPosition = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double addSalary = scanner.nextDouble();
                    scanner.nextLine(); 
                    management.addEmployee(new Employee(addId, addName, addPosition, addSalary));
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = scanner.nextLine();
                    Employee employee = management.searchEmployee(searchId);
                    if (employee != null) {
                        System.out.println("Employee found: " + employee.getName() + ", Position: " + employee.getPosition());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("Employee List:");
                    management.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    management.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully.");
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
