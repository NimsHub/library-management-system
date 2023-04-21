package org.nims.library;

import java.util.List;

public class Library {
    private final Transaction transactionService;

    public Library(Transaction transactionService) {
        this.transactionService = transactionService;
    }

    public void addBook(Book book) {
        transactionService.addBook(book);
    }

    public void removeBook(Book book) {
        transactionService.removeBook(book);
    }

    public void borrowBook(Book book) {
        transactionService.borrowBook(book);
    }

    public void returnBook(Book book) {
        transactionService.returnBook(book);
    }

    public List<Book> availableBooks(){
       return transactionService.availableBooks();
    }

    public List<Book> borrowedBooks(){
        return transactionService.borrowedBooks();
    }
    public List<String > overdueBooks(){
        return transactionService.overdueBooks();
    }
}

