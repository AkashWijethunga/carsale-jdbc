package com.example.carsale.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeViewController {
    @FXML
    private AnchorPane root;

    @FXML
    void loadAddCar(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/addNewCar-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void loadDeleteCar(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/deleteCar-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadShowCar(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/loadAll-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void loadUpdateCar(ActionEvent event) {
        try {

            Stage stage = (Stage) this.root.getScene().getWindow();


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/updateCar-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());


            stage.setScene(scene);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
