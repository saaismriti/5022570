package searching;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),new Product(2, "Smartphone", "Electronics"),new Product(3, "Book", "Books"),
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        ProductSearch.sortProductsById(products);

        while (running) {
            System.out.println("\nE-commerce Platform Search Function");
            System.out.println("1. Linear Search by Product ID");
            System.out.println("2. Binary Search by Product ID");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID to search: ");
                    int linearSearchId = scanner.nextInt();
                    Product foundProductLinear = ProductSearch.linearSearch(products, linearSearchId);
                    if (foundProductLinear != null) {
                        System.out.println("Linear Search: Found " + foundProductLinear.getProductName());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to search: ");
                    int binarySearchId = scanner.nextInt();
                    Product foundProductBinary = ProductSearch.binarySearch(products, binarySearchId);
                    if (foundProductBinary != null) {
                        System.out.println("Binary Search: Found " + foundProductBinary.getProductName());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
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

