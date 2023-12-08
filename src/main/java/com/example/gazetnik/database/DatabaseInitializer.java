package com.example.gazetnik.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement()) {

            // Создание таблицы products
            String createProductsTable = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "quantity INTEGER NOT NULL)";
            statement.execute(createProductsTable);

            // Создание таблицы sales
            String createSalesTable = "CREATE TABLE IF NOT EXISTS sales (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "product_id INTEGER NOT NULL," +
                    "quantity_sold INTEGER NOT NULL," +
                    "FOREIGN KEY (product_id) REFERENCES products(id))";
            statement.execute(createSalesTable);

        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки (вывод сообщения, логирование и т. д.)
        }
    }
}