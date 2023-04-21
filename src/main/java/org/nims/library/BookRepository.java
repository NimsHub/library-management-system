package org.nims.library;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    List<Book> books;
    List<BorrowedBook> borrowedBooks;

    private BookRepository() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    public static synchronized BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }
}
