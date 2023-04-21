package org.nims.ui;

import org.nims.commands.CliCommands;
import org.nims.commands.Commands;
import org.nims.constants.Constants;
import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

public class CLI implements UIContract {
    Logger logger = new Logger();
    int choice;
    private final Commands commands;
    Scanner scanner = new Scanner(System.in);

    public CLI(Library library) {
        this.commands = new CliCommands(scanner, library);
    }

    @Override
    public void show() {

        try {
            do {
                logger.info(Constants.PROMPT);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> commands.addBook();
                    case 2 -> commands.removeBook();
                    case 3 -> commands.availableBooks();
                    case 4 -> commands.borrowBook();
                    case 5 -> commands.returnBook();
                    case 6 -> commands.borrowedBooks();
                    case 7 -> commands.overdueBooks();
                    default -> logger.warn("Invalid Input");
                }
            } while (choice != 8);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
