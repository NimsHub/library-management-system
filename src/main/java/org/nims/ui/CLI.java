package org.nims.ui;

import org.nims.commands.*;
import org.nims.constants.Constants;
import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

public class CLI implements UIContract {
    Logger logger = new Logger();
    int choice;
    // private final Commands commands;
    private final AddRemoveBooks addRemoveBooks;
    private final BorrowReturnBooks borrowReturnBooks;
    private final ShowBooks showBooks;
    Scanner scanner = new Scanner(System.in);

    public CLI(Library library) {
        // this.commands = new CliCommands(scanner, library);
        this.addRemoveBooks =new AddRemoveBooksCommands(scanner, library);
        this.borrowReturnBooks =new BorrowReturnBooksCommands(scanner, library);
        this.showBooks =new ShowBooksCommands(scanner, library);
    }

    @Override
    public void show() {

        try {
            do {
                logger.info(Constants.PROMPT);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addRemoveBooks.addBook();
                    case 2 -> addRemoveBooks.removeBook();
                    case 3 -> showBooks.availableBooks();
                    case 4 -> borrowReturnBooks.borrowBook();
                    case 5 -> borrowReturnBooks.returnBook();
                    case 6 -> showBooks.borrowedBooks();
                    case 7 -> showBooks.overdueBooks();
                    default -> logger.warn("Invalid Input");
                }
            } while (choice != 8);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
