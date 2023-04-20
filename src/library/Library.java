package library;

import java.util.List;

public class Library {
    private final Transaction transactionService;
    private final Retrieval retrievalService;
    public Library(Transaction transactionService, Retrieval retrievalService) {
        this.transactionService = transactionService;
        this.retrievalService = retrievalService;
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
       return retrievalService.availableBooks();
    }

    public List<Book> borrowedBooks(){
        return retrievalService.borrowedBooks();
    }
}
