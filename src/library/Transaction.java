package library;


public interface Transaction {
    void addBook(Book book);
    void removeBook(Book book);
    void borrowBook(Book book);
    void returnBook(Book book);
}
