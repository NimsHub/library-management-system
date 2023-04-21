package org.nims;

import org.nims.library.*;

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        BookRepository bookDb = BookRepository.getInstance();
        Transaction transactionService = new TransactionService(bookDb,logger);
        Library library = new Library(transactionService);

        Book book1 = new Book(1,"title 1","author 1",false);
        Book book2 = new Book(2,"title 2","author 2",false);
        Book book3 = new Book(3,"title 3","author 3",false);
        Book book4 = new Book(4,"title 4","author 4",false);
        Book book5 = new Book(5,"title 5","author 5",false);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.borrowBook(book1);
        library.borrowBook(book2);

        logger.info(String.format("available books : %s",
                library.availableBooks().toString()));

        logger.info(String.format("borrowed books : %s",
                library.borrowedBooks().toString()));

        library.returnBook(book1);

        logger.info(String.format("available books : %s",
                library.availableBooks().toString()));

        library.removeBook(book3);

        logger.info(String.format("available books : %s",
                library.availableBooks().toString()));
    }
}