package org.nims.commands;

import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

public class ShowBooksCommands implements ShowBooks{
    private final Scanner scanner;
    private final Library library;
    Logger logger = new Logger();
    public ShowBooksCommands(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
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
