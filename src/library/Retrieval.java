package library;

import java.util.List;

public interface Retrieval {
    List<Book> availableBooks();
    List<Book> borrowedBooks();
}
