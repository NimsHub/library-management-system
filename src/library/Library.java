package library;

import java.util.List;

public class Library {
    private final Transaction transactionService;
    private Db booksDb;

    public Library(Transaction transactionService, Db booksDb) {
        this.transactionService = transactionService;
        this.booksDb = booksDb;
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
       return transactionService.availabeBooks();
    }

    public List<Book> borrowedBooks(){
        return transactionService.borrowedBooks();
    }
}
