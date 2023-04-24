package org.nims.commands;

import org.nims.library.Library;
import org.nims.utils.Logger;

import java.util.Scanner;

public class AddRemoveBooksCommands implements AddRemoveBooks{
    private final Scanner scanner;
    private final Library library;
    Logger logger = new Logger();
    public AddRemoveBooksCommands(Scanner scanner, Library library) {
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
}
