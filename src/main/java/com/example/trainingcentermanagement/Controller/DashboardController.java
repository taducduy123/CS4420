package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.App;
import com.example.trainingcentermanagement.Utils.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private ListView<String> lstMenu;
    @FXML
    private AnchorPane contentPane;


    //----------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeDashboardByRole(UserContext.getInstance().getRole());

        loadPane(lstMenu.getSelectionModel().getSelectedItem()); // loadPane("menu1")
    }


    private void initializeDashboardByRole(String role) {
        String tempRole = role.toLowerCase();

        switch (tempRole) {
            case "student":
                lstMenu.getItems().addAll("Profile", "Register", "Course", "Transaction");
                lstMenu.getSelectionModel().selectFirst();
                break;

            case "instructor":
                lstMenu.getItems().addAll("Profile", "Course", "Transaction");
                lstMenu.getSelectionModel().selectFirst();
                break;

            case "manager":
                lstMenu.getItems().addAll("Profile", "Instructor", "Student", "Course", "Billing", "Payroll", "Statistical");
                lstMenu.getSelectionModel().selectFirst();
                break;
        }
    }


    private void loadPane(String selectedItem) {
        String frm = "";

        switch (selectedItem) {
            case "Profile":
                frm = "/com/example/trainingcentermanagement/ProfileView.fxml";
                break;

            case  "Billing":
                frm = "/com/example/trainingcentermanagement/BillingView.fxml";
                break;

            case  "Payroll":
                frm = "/com/example/trainingcentermanagement/PayrollView.fxml";
                break;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(frm));
            contentPane.getChildren().clear();

            AnchorPane newPane = loader.load(); // chua noi dung cua fxml da chon // copy

            contentPane.getChildren().add(newPane); // them noi dung vao content pane // paste

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onSelectedMenu(MouseEvent mouseEvent) {
        String selectedItem = lstMenu.getSelectionModel().getSelectedItem();

        if(selectedItem != null){
            loadPane(selectedItem);
        }
    }


    public void OnClickLogOut(ActionEvent actionEvent) {
        UserContext.getInstance().clearContext();
        try {
            App.setRootAs("LoginView");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnClickChangePassword(ActionEvent actionEvent) {
        try {
            App.popup("ChangePasswordView", "Change Password", 600, 465);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
