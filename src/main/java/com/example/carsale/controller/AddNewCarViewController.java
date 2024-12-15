package com.example.carsale.controller;

import com.example.carsale.dto.Vehicledto;
import com.example.carsale.tm.VehicleTM;
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

public class AddNewCarViewController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField brandtxt;

    @FXML
    private TextField modeltxt;

    @FXML
    private TextField pricetxt;

    @FXML
    private TextField qtytxt;

    @FXML
    void addCar(ActionEvent event) {
        String brand = brandtxt.getText();
        String model = modeltxt.getText();
        double price = Double.parseDouble(pricetxt.getText());
        int qty = Integer.parseInt(qtytxt.getText());

       boolean i= VehicleModel.addNewCar(new Vehicledto(brand,model,qty,price));

        if(i==true){
            Alert.AlertType alertType = Alert.AlertType.CONFIRMATION;
            Alert alert = new Alert(alertType);
            alert.setTitle("CONFIRMATION ALERT");
            alert.setHeaderText("Car added successfully");
            alert.show();

        }else{
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("ERROR ALERT");
            alert.setHeaderText("Car not added successfully");
            alert.show();
        }

    }


    @FXML
    void backToMenu(ActionEvent event) {
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

