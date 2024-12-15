module com.example.carsale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.carsale to javafx.fxml;
    exports com.example.carsale;
    exports com.example.carsale.controller;
    opens com.example.carsale.controller to javafx.fxml;
    exports com.example.carsale.dto;
    opens com.example.carsale.dto to javafx.fxml;
    exports com.example.carsale.tm;
    opens com.example.carsale.tm to javafx.fxml;
}