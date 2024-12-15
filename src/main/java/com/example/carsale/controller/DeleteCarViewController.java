package com.example.carsale.controller;

import com.example.carsale.modle.VehicleModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCarViewController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtId;

    @FXML
    void btnDelete(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
      if(id>0) {

          boolean i= VehicleModel.deleteCar(id);

              if (i==true) {
                  Alert.AlertType alertType = Alert.AlertType.CONFIRMATION;
                  Alert alert = new Alert(alertType);
                  alert.setTitle("CONFIRMATION ALERT");
                  alert.setHeaderText("Car Delete successfully");
                  alert.show();

              } else {
                  Alert.AlertType alertType = Alert.AlertType.ERROR;
                  Alert alert = new Alert(alertType);
                  alert.setTitle("ERROR ALERT");
                  alert.setHeaderText("Car not Delete successfully");
                  alert.show();
              }



      }





    //-----back---------
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
