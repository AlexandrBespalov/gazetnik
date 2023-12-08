package com.example.gazetnik.ui;

import com.example.gazetnik.model.Product;
import com.example.gazetnik.service.ProductService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ProductInputController {
    @FXML
    private TextField productNameField;

    @FXML
    private TextField quantityField;

    @FXML
    private Button addButton;

    private final ProductService productService;

    public ProductInputController() {
        this.productService = new ProductService();
    }

    @FXML
    private void initialize() {
        addButton.setOnAction(event -> addProduct());
    }

    private void addProduct() {
        String productName = productNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        Product product = new Product();
        product.setName(productName);
        product.setQuantity(quantity);

        try {
            productService.addProduct(product);
            // Обновление интерфейса или вывод сообщения об успешной операции
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки (вывод сообщения, логирование и т. д.)
        }
    }
}