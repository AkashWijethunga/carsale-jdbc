package com.example.carsale.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    @FXML
    private AnchorPane root;

    @FXML
    void btnOrder(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/orderForm-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnVehicle(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/home-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}
