module com.example.trainingcentermanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires commons.dbutils;
    requires mysql.connector.j;
    requires java.xml.crypto;
    requires static lombok;
    requires java.mail;         // for builder


    opens com.example.trainingcentermanagement to javafx.fxml;
    opens com.example.trainingcentermanagement.Controller to javafx.fxml;       // Link Controller to fxml file
    opens com.example.trainingcentermanagement.Model to javafx.fxml;
    opens com.example.trainingcentermanagement.Services to javafx.fxml;
    opens com.example.trainingcentermanagement.Repository to javafx.fxml;
    opens com.example.trainingcentermanagement.Utils to javafx.fxml;


    exports com.example.trainingcentermanagement;
    exports com.example.trainingcentermanagement.Controller;
    exports com.example.trainingcentermanagement.Model;
    exports com.example.trainingcentermanagement.Services;
    exports com.example.trainingcentermanagement.Repository;
    exports com.example.trainingcentermanagement.Utils;
}