package org.nims.library;

import java.util.List;

public interface Transaction {
    void addBook(Book book);
    void removeBook(Book book);
    void borrowBook(Book book);
    void returnBook(Book book);
    List<Book> availableBooks();
    List<Book> borrowedBooks();
    List<String> overdueBooks();
    Book getBookById(int id);

}
