package library;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
/**
This service class includes the functionalities for basic transactions with the library
 */
public class TransactionService implements Transaction{
    private Db bookDb;
    private Logger logger;

    public TransactionService(Db bookDb, library.Logger logger) {
        this.bookDb = bookDb;
        this.logger = logger;
    }

    /**
     *
     * @param newBook : Book
     */
    @Override
    public void addBook(Book newBook) {
        bookDb.books.add(newBook);
        logger.info("new book has been added");
    }

    @Override
    public void removeBook(Book book) {
        bookDb.books.remove(book);
        logger.info("book has been removed");
    }

    @Override
    public void borrowBook(Book book) {
        bookDb.books.stream().filter(a -> a.getId() == book.getId())
                .findAny()
                .ifPresent(a-> a.setBorrowed(true));
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setDueDate(LocalDate.now());
        bookDb.borrowedBooks.add(borrowedBook);
        logger.info("book has been borrowed");
    }

    @Override
    public void returnBook(Book book) {
        bookDb.books.stream().filter(a -> a.getId() == book.getId())
                .findAny()
                .ifPresent(a-> a.setBorrowed(false));
        bookDb.borrowedBooks.remove(bookDb.borrowedBooks.stream().filter(a -> a.getBook() == book)
                .findAny().orElseThrow(()-> new RuntimeException("no such borrowings")));
        logger.info("book has been returned");
    }

}
