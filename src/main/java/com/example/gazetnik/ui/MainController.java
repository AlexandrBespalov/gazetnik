package com.example.gazetnik.ui;

import com.example.gazetnik.model.Product;
import com.example.gazetnik.model.Sale;
import com.example.gazetnik.service.ProductService;
import com.example.gazetnik.service.SaleService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class MainController {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField quantityField;

    @FXML
    private Button addButton;

    @FXML
    private ListView<Product> productList;

    @FXML
    private ListView<Sale> salesList;

    private final ProductService productService;
    private final SaleService saleService;

    public MainController() {
        this.productService = new ProductService();
        this.saleService = new SaleService();
    }

    @FXML
    private void initialize() {
        addButton.setOnAction(event -> addProduct());

        // Обновление списка продуктов и продаж при запуске приложения
        try {
            updateProductList();
            updateSalesList();
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки (вывод сообщения, логирование и т. д.)
        }
    }

    @FXML
    private void addProduct() {
        String productName = productNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        Product product = new Product();
        product.setName(productName);
        product.setQuantity(quantity);

        try {
            productService.addProduct(product);
            updateProductList();
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки (вывод сообщения, логирование и т. д.)
        }
    }

    private void updateProductList() throws SQLException {
        List<Product> products = productService.getAllProducts();
        productList.getItems().setAll(products);
    }

    private void updateSalesList() throws SQLException {
        // Предположим, что выбран первый продукт из списка для отображения связанных продаж
        if (!productList.getItems().isEmpty()) {
            int selectedProductId = productList.getItems().get(0).getId();
            List<Sale> sales = saleService.getSalesByProductId(selectedProductId);
            salesList.getItems().setAll(sales);
        }
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}