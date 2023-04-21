package org.nims;

import org.nims.library.BookRepository;
import org.nims.library.Library;
import org.nims.library.Transaction;
import org.nims.library.TransactionService;
import org.nims.ui.UI;
import org.nims.ui.UIContract;
import org.nims.ui.UIFactory;
import org.nims.utils.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        BookRepository bookDb = BookRepository.getInstance();
        Transaction transactionService = new TransactionService(bookDb,logger);
        Library library = new Library(transactionService);

        library.addBook("title 1","author 1");
        library.addBook("title 2","author 2");
        library.addBook("title 3","author 3");
        library.addBook("title 4","author 4");
        library.addBook("title 5","author 5");

        UIFactory uiFactory = new UIFactory(library);
        UIContract ui = uiFactory.getUI(UI.CLI);
        ui.show();

    }

}