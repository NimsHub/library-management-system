package library;

import java.util.List;

public interface Transaction {
    void addBook(Book book);
    void removeBook(Book book);
    void borrowBook(Book book);
    void returnBook(Book book);
    List<Book> availabeBooks();
    List<Book> borrowedBooks();
}
