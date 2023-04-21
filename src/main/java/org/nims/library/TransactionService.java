package org.nims.library;

import java.time.LocalDate;
import java.util.List;
/**
This service class includes the functionalities for basic transactions with the library
 */
public class TransactionService implements Transaction{
    private final BookRepository bookRepository;
    private final Logger logger;

    public TransactionService(BookRepository bookRepository, Logger logger) {
        this.bookRepository = bookRepository;
        this.logger = logger;
    }

    /**
     * This method add books to the library
     * @param newBook : Book
     */
    @Override
    public void addBook(Book newBook) {
        bookRepository.books.add(newBook);
        logger.info("new book has been added");
    }

    /**
     * This method remove books from the library
     * @param book : Book
     */
    @Override
    public void removeBook(Book book) {
        bookRepository.books.remove(book);
        logger.info("book has been removed");
    }
    /**
     * This method illustrates borrowing a book from the library
     * @param book : Book
     */
    @Override
    public void borrowBook(Book book) {
        bookRepository.books.stream()
                .filter(a -> a.getId() == book.getId())
                .findAny()
                .ifPresent(a-> a.setBorrowed(true));

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setDueDate(LocalDate.now());

        bookRepository.borrowedBooks.add(borrowedBook);
        logger.info("book has been borrowed");
    }
    /**
     * This method illustrates returning borrowed book to the library
     * @param book : Book
     */
    @Override
    public void returnBook(Book book) {
        bookRepository.books.stream()
                .filter(a -> a.getId() == book.getId())
                .findAny()
                .ifPresent(a-> a.setBorrowed(false));

        bookRepository.borrowedBooks.remove(
                bookRepository.borrowedBooks.stream()
                        .filter(a -> a.getBook() == book)
                        .findAny()
                        .orElseThrow(()-> new RuntimeException("no such borrowings")));

        logger.info("book has been returned");
    }

    /**
     * This method retrieves all the available books in the library
     * @return List<Book>
     */
    @Override
    public List<Book> availableBooks() {
        return bookRepository.books.stream()
                .filter(a-> !a.isBorrowed())
                .toList();
    }

    /**
     * This method retrieves all the borrowed books from the library
     * @return : List<Book>
     */
    @Override
    public List<Book> borrowedBooks() {
        return bookRepository.books.stream()
                .filter(Book::isBorrowed)
                .toList();
    }
}
