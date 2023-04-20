package library;

import java.util.ArrayList;
import java.util.List;

public class Db {
    private static Db instance;
    List<Book> books;
    List<BorrowedBook> borrowedBooks;

    private Db() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    public static synchronized Db getInstance() {
        if (instance == null) {
            instance = new Db();
        }
        return instance;
    }
}
