package org.nims.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException{
        String jdbcUrl = "jdbc:sqlite:library.db";
        Connection connection = DriverManager.getConnection(jdbcUrl);

        String sql = "CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY, title TEXT, author TEXT, borrowed BOOLEAN)";
        Statement statement = connection.createStatement();
        statement.execute(sql);

        System.out.println("Table created successfully");
    }
}
