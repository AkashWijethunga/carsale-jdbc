package com.example.carsale.controller;

import com.example.carsale.modle.VehicleModel;
import com.example.carsale.tm.VehicleTM;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllViewController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<VehicleTM> tableId;

    @FXML
    void btnBack(ActionEvent event) {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<VehicleTM> tms= VehicleModel.getAllCars();

        tableId.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Id"));
        tableId.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tableId.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tableId.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tableId.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        tableId.setItems(FXCollections.observableList(tms));
    }
}
