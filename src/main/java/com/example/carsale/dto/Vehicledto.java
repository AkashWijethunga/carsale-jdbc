package com.example.carsale.dto;

public class Vehicledto {
    private String brand;
    private String model;
    private int qty;
    private double price;

    public Vehicledto(String brand, String model, int qty, double price) {
        this.setBrand(brand);
        this.setModel(model);
        this.setQty(qty);
        this.setPrice(price);
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
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
