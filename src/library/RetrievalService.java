package library;

import java.util.List;
import java.util.Optional;

public class RetrievalService implements Retrieval {
    private Db bookDb;
    private Logger logger;
    public RetrievalService(Db bookDb, library.Logger logger) {
        this.bookDb = bookDb;
        this.logger = logger;
    }

    @Override
    public List<Book> availableBooks() {
        return bookDb.books.stream().filter(a-> !a.isBorrowed()).toList();
    }

    @Override
    public List<Book> borrowedBooks() {
        return bookDb.books.stream().filter(Book::isBorrowed).toList();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book = bookDb.books.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return book.orElse(null); // return the book if present, or null otherwise
    }

}
