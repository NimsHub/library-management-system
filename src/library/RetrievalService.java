package library;

import java.util.List;

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
}
