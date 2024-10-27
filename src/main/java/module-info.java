module com.example.trainingcentermanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires commons.dbutils;
    requires mysql.connector.j;
    requires java.xml.crypto;


    opens com.example.trainingcentermanagement to javafx.fxml;
    opens com.example.trainingcentermanagement.Controller to javafx.fxml;       // Link Controller to fxml file

    exports com.example.trainingcentermanagement;
    exports com.example.trainingcentermanagement.Controller;
}