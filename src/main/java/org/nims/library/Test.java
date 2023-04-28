package org.nims.library;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.nims.entities.Book;
import org.nims.entities.Borrowings;

public class Test {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:sqlite:library.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);

//        createTables(connection);
//        addData(connection, testData());
        removeData(connection,3);
        List<Book> books = getData(connection);

        System.out.println("Library inventory:");
        for (Book book : books) {
            System.out.println(book);
        }

        connection.close();
    }

    public static void createTables(Connection connection) throws SQLException {
        createBookTable(connection);
//        createBorrowingsTable(connection);
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
            String columnDefinition = columnName + " " + fieldType + ", ";
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

    public static void addData(Connection connection, Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, borrowed) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setBoolean(3, book.isBorrowed());
        statement.executeUpdate();
    }

    public static void removeData(Connection connection, int id) throws SQLException {
        String selectSql = "SELECT * FROM books WHERE id = ?";
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setInt(1, id);
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            String deleteSql = "DELETE FROM books WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } else {
            System.out.println("No record found with id = " + id);
        }
    }

    public static List<Book> getData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            boolean isBorrowed = resultSet.getBoolean("borrowed");
            Book book = new Book.BookBuilder()
                    .title(title)
                    .author(author)
                    .isBorrowed(isBorrowed)
                    .build();
            book.setId(id);
            books.add(book);
        }

        return books;
    }

    public static Book testData() {
        return new Book.BookBuilder()
                .title("The Great Gatsby")
                .author("F. Scott Fitzgerald")
                .isBorrowed(false)
                .build();
    }
}