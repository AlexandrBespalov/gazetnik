package com.example.gazetnik.model;

public class Sale {
    private int id;
    private int productId;
    private int quantitySold;

    // геттеры и сеттеры

    // Добавляем методы:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "Sale{id=" + id + ", productId=" + productId + ", quantitySold=" + quantitySold + '}';
    }
}