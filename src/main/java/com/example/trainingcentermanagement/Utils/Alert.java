package com.example.trainingcentermanagement.Utils;

import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alert {


    //-------------------------------------------------------------------------------------------

    public Alert() {
    }

    public static void showAlert(javafx.scene.control.Alert.AlertType type, String title, String header, String content) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static boolean showConfirmation(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, message);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
