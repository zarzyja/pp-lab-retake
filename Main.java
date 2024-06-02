import java.util.Scanner;

public class Main {
    private static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("[1] Add book");
        System.out.println("[2] Remove book");
        System.out.println("[3] Update book");
        System.out.println("[4] List books");
        System.out.println("[5] Exit");
        System.out.print("Choose an option: ");
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book book = new Book(title, author, isbn, year);
        bookManager.addBook(book);
        System.out.println("Book added.");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        bookManager.removeBook(isbn);
        System.out.println("Book removed.");
    }

    private static void updateBook() {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Book updatedBook = new Book(title, author, isbn, year);
        bookManager.updateBook(isbn, updatedBook);
        System.out.println("Book updated.");
    }

    private static void listBooks() {
        for (Book book : bookManager.getBooks()) {
            System.out.println(book);
        }
    }
}

