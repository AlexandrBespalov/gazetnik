package com.example.gazetnik.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:sqlite:gazetnik.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}