package org.nims.library;

import org.nims.entities.Book;
import org.nims.entities.Borrowings;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    List<Book> books;
    List<Borrowings> borrowings;

    private BookRepository() {
        books = new ArrayList<>();
        borrowings = new ArrayList<>();
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }
}
