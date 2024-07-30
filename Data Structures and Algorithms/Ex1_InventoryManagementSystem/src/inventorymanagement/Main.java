package inventorymanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    scanner.nextLine(); 
                    inventory.addProduct(new Product(addId, addName, addQuantity, addPrice));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); 
                    inventory.updateProduct(updateId, new Product(updateId, updateName, updateQuantity, updatePrice));
                    System.out.println("Product updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    inventory.deleteProduct(deleteId);
                    System.out.println("Product deleted successfully.");
                    break;

                case 4:
                    System.out.println("Product List:");
                    inventory.displayProducts();
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
