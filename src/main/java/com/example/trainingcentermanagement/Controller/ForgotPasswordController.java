package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.App;
import com.example.trainingcentermanagement.Services.ForgotPasswordService;
import com.example.trainingcentermanagement.Services.MailService;
import com.example.trainingcentermanagement.Utils.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

public class ForgotPasswordController implements Initializable {
    @FXML
    private ComboBox<String> cbRole;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtEmail;

    private final MailService mailService;
    private final ForgotPasswordService forgotPasswordService;

    //----------------------------------------------------------------------------

    public ForgotPasswordController() {
        mailService = new MailService("smtp.gmail.com");
        forgotPasswordService = new ForgotPasswordService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbRole.getItems().addAll("Student", "Instructor", "Manager");
        cbRole.setValue("Student");
    }

    public void OnClickResetPassword(ActionEvent actionEvent) throws IOException {

        // Get user input
        String role = cbRole.getValue().toLowerCase();
        String username = txtUsername.getText();
        String email = txtEmail.getText();

        // Validate user input
        if (role.isEmpty() || username.isEmpty() || email.isEmpty()) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Please fill all the required fields!");
            return;
        }
        else if (!forgotPasswordService.checkMatching(role, username, email)) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Role and Username and Email do not match!");
            return;
        }

        // Send new password to user's email
        String newPassword = UUID.randomUUID().toString().substring(0,5).toLowerCase();
        String message = "The following is your account after resetting password:" +
                         "\n username: " + username +
                         "\n password: " + newPassword;
        Map<String, String> map = new HashMap<>();
        map.put(email, message);
        mailService.sendMail(map, "Training Center Management System");

        // Update new password in the database
        forgotPasswordService.resetUserPassword(role, username, newPassword);
        Alert.showConfirmation("Reset password completed! Please check your email!");


    }
}
