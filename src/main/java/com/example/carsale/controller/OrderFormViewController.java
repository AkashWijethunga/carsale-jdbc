package com.example.carsale.controller;

import com.example.carsale.dto.OrderDetailDto;
import com.example.carsale.dto.OrderDto;
import com.example.carsale.dto.Vehicledto;
import com.example.carsale.modle.OrderModel;
import com.example.carsale.modle.VehicleModel;
import com.example.carsale.tm.ItemTM;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderFormViewController implements Initializable {

    private double totalCost;
    @FXML
    private Label lblTotal;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<ItemTM> tblOrder;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModle;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtQtyOnHand;

    private List<ItemTM> items;

    private ArrayList<OrderDetailDto> orderDetailDtos;

    @FXML
    void Back(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addToCart(ActionEvent event) {
        int qty = Integer.parseInt(txtQty.getText());
        String brand = txtBrand.getText();
        String modle = txtModle.getText();
        double price = Double.parseDouble(txtPrice.getText());
        double total = qty * price;
        totalCost += total;
        lblTotal.setText(String.format("%.2f", totalCost));
        items.add(new ItemTM(brand,modle,qty,price,total));

        orderDetailDtos.add(new OrderDetailDto(Integer.parseInt(txtId.getText()),qty,total));

        tblOrder.setItems(FXCollections.observableArrayList(items));
    }

    @FXML
    void placeOrder(ActionEvent event) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = currentDate.format(formatter);

        try {
        boolean orderPlaced=OrderModel.placeOrder(new OrderDto(formattedDate,totalCost,orderDetailDtos));
        if(orderPlaced){
            System.out.println("Order Placed");
        }else {
            System.out.println("Order Not Placed");
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void searchId(ActionEvent event) {
        int id =Integer.parseInt(txtId.getText());
        Vehicledto vehicledto= VehicleModel.serchCar(id);

        txtBrand.setText(vehicledto.getBrand());
        txtModle.setText(vehicledto.getModel());
        txtQtyOnHand.setText(String.valueOf(vehicledto.getQty()));
        txtPrice.setText(String.valueOf(vehicledto.getPrice()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        items=new ArrayList();
        orderDetailDtos=new ArrayList();
    }
}
