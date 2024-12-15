package com.example.carsale.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    String username="admin";
    String password = "1234";
    @FXML
    private AnchorPane root;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void getLogin(ActionEvent event) {
        if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("1234")){
            try {

                Stage stage = (Stage) this.root.getScene().getWindow();


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/carsale/main-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());


                stage.setScene(scene);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("ERROR ALERT");
            alert.setHeaderText("Wrong Username or Password");
            alert.show();
        }


    }
}
