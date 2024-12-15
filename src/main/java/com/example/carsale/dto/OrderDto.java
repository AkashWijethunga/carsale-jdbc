package com.example.carsale.dto;
import java.util.ArrayList;


public class OrderDto {
    private String orderDate;
    private double totalPrice;
    private ArrayList<OrderDetailDto>orderDetailDtos;

    public OrderDto(String orderDate, double totalPrice, ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderDetailDtos = orderDetailDtos;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    public void setOrderDetailDtos(ArrayList<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }
}
