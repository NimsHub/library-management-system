package org.nims.db;

import org.nims.entities.Book;
import org.nims.entities.Borrowings;
import org.nims.library.BookRepository;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticDb {
    private static StaticDb instance;
    public Connection connection;
    private StaticDb() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String username = "user";
        String password = "mypassword";
        this.connection = DriverManager.getConnection(jdbcUrl, username, password);
        createTables(connection);
    }
    public static synchronized StaticDb getInstance(){
        if (instance == null) {
            try {
                instance = new StaticDb();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public static void createTables(Connection connection) throws SQLException {
        createBookTable(connection);
        createBorrowingsTable(connection);
    }

    public static void createBookTable(Connection connection) throws SQLException {
        String tableName = "books";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "title VARCHAR(255),"
                + "author VARCHAR(255),"
                + "isBorrowed INT(1)"
                + ");";
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    public static void createBorrowingsTable(Connection connection) throws SQLException {

        String tableName = "borrowings";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "dueDate DATE,"
                + "borrower VARCHAR(255),"
                + "book INT(11) NOT NULL,"
                + "FOREIGN KEY (book) REFERENCES books(id)"
                + ");";
        Statement statement = connection.createStatement();
        statement.execute(sql);

    }
}
