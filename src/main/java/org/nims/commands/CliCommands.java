package org.nims.commands;


import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

/**
 * This class holds all the commands for cli
 */
public class CliCommands implements Commands{
    private final Scanner scanner;
    private final Library library;
    Logger logger = new Logger();
    public CliCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }


    @Override
    public void addBook() {
        scanner.nextLine(); // to consume the newline character
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        library.addBook(title,author);
    }

    @Override
    public void removeBook() {
        scanner.nextLine(); // to consume the newline character
        System.out.print("Enter Id: ");
        String id = scanner.nextLine();
        library.removeBook(Integer.parseInt(id));
    }

    @Override
    public void borrowBook() {
        scanner.nextLine(); // to consume the newline character
        System.out.print("Enter Id: ");
        String id = scanner.nextLine();
        System.out.print("Enter Borrower's Name: ");
        String borrower = scanner.nextLine();
        library.borrowBook(Integer.parseInt(id),borrower);
    }

    @Override
    public void returnBook() {
        scanner.nextLine(); // to consume the newline character
        System.out.print("Enter Id: ");
        String id = scanner.nextLine();
        library.returnBook(Integer.parseInt(id));
    }

    @Override
    public void availableBooks() {
        logger.info(String.format("available books : %s",
                library.availableBooks().toString()));
    }

    @Override
    public void borrowedBooks() {
        logger.info(String.format("borrowed books : %s",
                library.borrowedBooks().toString()));
    }

    @Override
    public void overdueBooks() {
        logger.info(String.format("overdue books : %s",
                library.overdueBooks().toString()));
    }
}
