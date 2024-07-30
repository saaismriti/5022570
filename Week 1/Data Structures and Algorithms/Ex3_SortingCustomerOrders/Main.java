package sorting;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Zoe", 999.99),
            new Order("O002", "Inaya", 359.90),
            new Order("O003", "Jason", 1200.00)
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSorting Customer Orders");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Bubble Sort
                	DifferentSorts.bubbleSort(orders);
                    System.out.println("Bubble Sort:");
                    for (Order order : orders) {
                        System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
                    }
                    break;

                case 2:
                    // Quick Sort
                	DifferentSorts.quickSort(orders, 0, orders.length - 1);
                    System.out.println("Quick Sort:");
                    for (Order order : orders) {
                        System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
                    }
                    break;

                case 3:
                    // Exit
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
