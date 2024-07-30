package linkedlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String addStatus = scanner.nextLine();
                    operations.addTask(new Task(addId, addName, addStatus));
                    System.out.println("Task added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = scanner.nextLine();
                    Task task = operations.searchTask(searchId);
                    if (task != null) {
                        System.out.println("Task found: " + task.getTaskName() + ", Status: " + task.getStatus());
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.println("Task List:");
                    operations.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    String deleteId = scanner.nextLine();
                    operations.deleteTask(deleteId);
                    System.out.println("Task deleted successfully.");
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
