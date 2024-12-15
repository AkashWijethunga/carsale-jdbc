package com.example.carsale.tm;

public class ItemTM {
    private String brand;
    private String model;
    private int Qty;
    private double price;
    private double total;

    public ItemTM(String brand, String model, int qty, double price, double total) {
        this.brand = brand;
        this.model = model;
        Qty = qty;
        this.price = price;
        this.total = total;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
