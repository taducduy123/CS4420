package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.App;
import com.example.trainingcentermanagement.Services.ChangePasswordService;
import com.example.trainingcentermanagement.Utils.Alert;
import com.example.trainingcentermanagement.Utils.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {
    @FXML
    private PasswordField txtNewPW;
    @FXML
    private PasswordField txtCurrentPW;
    @FXML
    private PasswordField txtReNewPW;
    @FXML
    private Button btnChangePW;


    private ChangePasswordService changePasswordService;
    //---------------------------------------------------------------------

    public ChangePasswordController() {
        this.changePasswordService = new ChangePasswordService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void OnClickChangePassword(ActionEvent actionEvent) {

        // Get user input
        String currentPW = txtCurrentPW.getText();
        String newPW = txtNewPW.getText();
        String reNewPW = txtReNewPW.getText();

        // Validate user input
        if(currentPW.isEmpty() || newPW.isEmpty() || reNewPW.isEmpty()) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Please fill all the required fields!");
            return;
        }
        else if(newPW.compareTo(reNewPW) != 0) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "New password and Re password do not match!");
            return;
        }
        else if (currentPW.compareTo(UserContext.getInstance().getPassword()) != 0) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Current password is wrong!");
            return;
        }

        // Update database
        String currentRole = UserContext.getInstance().getRole();
        String currentUsername = UserContext.getInstance().getUsername();
        changePasswordService.updateUserPasswordByUsername(currentRole, currentUsername, newPW);

        // Update User Context
        UserContext.getInstance().setPassword(newPW);

        // Show confirmation message
        Alert.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION,
                "",
                null,
                "Password changed successfully!");

        // Back to Dashboard
        try {
            App.setRootAs("DashboardView");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
