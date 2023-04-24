package org.nims.commands;

import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

public class BorrowReturnBooksCommands implements BorrowReturnBooks {
    private final Scanner scanner;
    private final Library library;
    Logger logger = new Logger();
    public BorrowReturnBooksCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
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
}
