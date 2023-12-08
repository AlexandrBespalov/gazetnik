// SaleService.java
package com.example.gazetnik.service;

import com.example.gazetnik.database.SaleDAO;
import com.example.gazetnik.model.Sale;

import java.sql.SQLException;
import java.util.List;

public class SaleService {
    private final SaleDAO saleDAO;

    public SaleService() {
        this.saleDAO = new SaleDAO();
    }

    public void recordSale(Sale sale) throws SQLException {
        saleDAO.recordSale(sale);
    }

    public List<Sale> getSalesByProductId(int productId) throws SQLException {
        return saleDAO.getSalesByProductId(productId);
    }
}