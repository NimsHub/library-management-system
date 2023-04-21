package org.nims.library;

import java.util.Scanner;

public class CommandLineUI implements UserInterface{
    @Override
    public void show() {
      
        Logger logger = new Logger();
        BookRepository bookDb = BookRepository.getInstance();
        Transaction transactionService = new TransactionService(bookDb,logger);
        Library library = new Library(transactionService);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Borrow book");
                System.out.println("5. Return book");
                System.out.println("6. Display borrowed books");
                System.out.println("7. Display overdue books");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();
                if (choice == 1) {
                    scanner.nextLine(); // to consume the newline character
                    System.out.print("Enter Id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Is borrowed ");
                    boolean borrowed = scanner.nextBoolean();
                    int ID = Integer.parseInt(id);
                    Book book1 = new Book(ID,title,author,borrowed);
                    library.addBook(book1);
                }
                else if (choice == 2) {
                    scanner.nextLine(); // to consume the newline character
                    System.out.print("Enter Id: ");
                    String id = scanner.nextLine();
                    int ID = Integer.parseInt(id);
                    Book removeBook= library.getBookById(ID);
                    library.removeBook(removeBook);

                }
                else if (choice == 3) {
                    System.out.println("available books");
                    System.out.println(library.availableBooks());
                }
                else if (choice == 4) {
                    scanner.nextLine(); // to consume the newline character
                    System.out.print("Enter Id: ");
                    String id = scanner.nextLine();
                    int ID = Integer.parseInt(id);
                    Book browedBook= library.getBookById(ID);
                    library.borrowBook(browedBook);

                }
                else if (choice == 5) {
                    scanner.nextLine(); // to consume the newline character
                    System.out.print("Enter Id: ");
                    String id = scanner.nextLine();
                    int ID = Integer.parseInt(id);
                    Book returnBook= library.getBookById(ID);
                    library.returnBook(returnBook);

                }
                else if (choice == 6) {
                    System.out.println("borrowed books");
                    System.out.println(library.borrowedBooks());
                }
                else if (choice == 7) {
                    System.out.println("overdue books");
                    System.out.println(library.overdueBooks());
                }
                else if (choice == 8) {
                    break;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


