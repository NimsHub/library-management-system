package org.nims.db;

import org.nims.entities.Book;
import org.nims.entities.Borrowings;
import org.nims.library.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class DynamicDb {
    private static DynamicDb instance;
    public List<Book> books;
    public List<Borrowings> borrowings;
    private DynamicDb() {
        books = new ArrayList<>();
        borrowings = new ArrayList<>();
    }
    public static synchronized DynamicDb getInstance() {
        if (instance == null) {
            instance = new DynamicDb();
        }
        return instance;
    }
}
