package librarysearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Girl In Pieces", "Kathleen Glasglow"),
            new Book("B002", "The Midnight Library", "Matt Haig"),
            new Book("B003", "Deep Work", "Cal Newport")
        };

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Sort books by title for binary search
        BookSearch.sortBooksByTitle(books);

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Linear Search
                    System.out.print("Enter Book Title to search: ");
                    String linearSearchTitle = scanner.nextLine();
                    Book foundBookLinear = BookSearch.linearSearch(books, linearSearchTitle);
                    if (foundBookLinear != null) {
                        System.out.println("Linear Search: Found " + foundBookLinear.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 2:
                    // Binary Search
                    System.out.print("Enter Book Title to search: ");
                    String binarySearchTitle = scanner.nextLine();
                    Book foundBookBinary = BookSearch.binarySearch(books, binarySearchTitle);
                    if (foundBookBinary != null) {
                        System.out.println("Binary Search: Found " + foundBookBinary.getTitle());
                    } else {
                        System.out.println("Book not found.");
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
