package com.example.gazetnik.service;

import com.example.gazetnik.database.ProductDAO;
import com.example.gazetnik.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public void addProduct(Product product) throws SQLException {
        productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }

    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    // Другие методы сервиса для работы с продуктами
}