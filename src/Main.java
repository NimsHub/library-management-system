import library.*;


public class Main {
    public static void main(String[] args) {
        Transaction transactionService = new TransactionService();
        Db bookDb = Db.getInstance();
        Library library = new Library(transactionService,bookDb);

        Book book1 = new Book(1,"title 1","author 1",false);
        Book book2 = new Book(2,"title 2","author 2",false);
        Book book3 = new Book(3,"title 3","author 3",false);
        Book book4 = new Book(4,"title 4","author 4",false);
        Book book5 = new Book(5,"title 5","author 5",false);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.borrowBook(book1);
        library.borrowBook(book2);

        System.out.println("available books");
        System.out.println(library.availableBooks());

        System.out.println("borrowed books");
        System.out.println(library.borrowedBooks());

        library.returnBook(book1);
        System.out.println("available books");
        System.out.println(library.availableBooks());

        library.removeBook(book3);

        System.out.println("available books");
        System.out.println(library.availableBooks());

    }
}