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
        String jdbcUrl = "jdbc:sqlite:library.db";
        connection = DriverManager.getConnection(jdbcUrl);
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
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

        Field[] fields = Book.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName().toUpperCase();
            String columnName = fieldName;
            if (fieldName.equals("isBorrowed")) {
                columnName = "borrowed";
            }
            String columnDefinition = columnName + " " + fieldType;
            if (fieldName.equals("id")) {
                columnDefinition += " INTEGER PRIMARY KEY AUTOINCREMENT, ";
            } else {
                columnDefinition += ", ";
            }
            sqlBuilder.append(columnDefinition);
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(")");

        Statement statement = connection.createStatement();
        statement.execute(sqlBuilder.toString());
    }

    public static void createBorrowingsTable(Connection connection) throws SQLException {
        String tableName = "borrowings";
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

        Field[] fields = Borrowings.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName().toUpperCase();
            String columnName = fieldName;
            String columnDefinition = columnName + " " + fieldType + ", ";
            sqlBuilder.append(columnDefinition);
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(")");

        Statement statement = connection.createStatement();
        statement.execute(sqlBuilder.toString());
    }
}
