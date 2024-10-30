package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.App;
import com.example.trainingcentermanagement.Model.Account;
import com.example.trainingcentermanagement.Services.AccountService;
import com.example.trainingcentermanagement.Utils.Alert;
import com.example.trainingcentermanagement.Utils.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ComboBox<String> cb_role;
    @FXML
    private TextField textField_username;
    @FXML
    private PasswordField textField_password;
    @FXML
    private Button button_login;
    @FXML
    private Hyperlink hLink_forgotPassword;

    private int i = 0;

    private final AccountService accountService;

    //---------------------------------------------------------------------------------
    public LoginController() {
        accountService = new AccountService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // = contructor for component


        System.out.println("Initialize is called");


        cb_role.getItems().addAll("Student", "Instructor", "Manager");
        cb_role.setValue("Student");
    }


    public void OnClickLogin(ActionEvent actionEvent) {

        // Get user input
        String role = cb_role.getValue().toLowerCase();
        String username = textField_username.getText();
        String password = textField_password.getText();

        // Validate user input
        if (role.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Please fill all the required fields!");
            return;
        }

        // Check if log in successfully
        Account currentAccount = Account.builder()
                .role(role)
                .username(username)
                .password(password)
                .build();
        if (accountService.checkLoginSuccess(currentAccount)) {
            System.out.println("Authentication successful with User: " +
                                UserContext.getInstance().toString());

            try {
                App.setRootAs("DashboardView");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Your account does not exist!");
        }


    }


    public void OnClickForgotPassword(ActionEvent actionEvent) {
        try {
            App.popup("ForgotPasswordView", "Reset Password", 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
