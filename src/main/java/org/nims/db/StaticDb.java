package org.nims.db;

import org.nims.library.BookRepository;

public class StaticDb {
    private static StaticDb instance;
    private StaticDb() {
        BookRepository.getInstance();
    }
    public static synchronized StaticDb getInstance() {
        if (instance == null) {
            instance = new StaticDb();
        }
        return instance;
    }
}
