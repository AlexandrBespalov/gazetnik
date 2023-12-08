package com.example.gazetnik.database;

import com.example.gazetnik.model.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    public void recordSale(Sale sale) throws SQLException {
        String query = "INSERT INTO sales (product_id, quantity_sold) VALUES (?, ?)";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, sale.getProductId());
            preparedStatement.setInt(2, sale.getQuantitySold());
            preparedStatement.executeUpdate();

            // Получение сгенерированного автоинкрементного ключа (если есть)
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    sale.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Sale> getSalesByProductId(int productId) throws SQLException {
        List<Sale> sales = new ArrayList<>();
        String query = "SELECT * FROM sales WHERE product_id=?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Sale sale = new Sale();
                    sale.setId(resultSet.getInt("id"));
                    sale.setProductId(resultSet.getInt("product_id"));
                    sale.setQuantitySold(resultSet.getInt("quantity_sold"));
                    sales.add(sale);
                }
            }
        }
        return sales;
    }

    // Другие методы для работы с продажами
}