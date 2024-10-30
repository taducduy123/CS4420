package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.Services.ProfileService;
import com.example.trainingcentermanagement.Utils.Alert;
import com.example.trainingcentermanagement.Utils.DoesExistChecker;
import com.example.trainingcentermanagement.Utils.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private TextField txtUserID;
    @FXML
    private TextField txtRole;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtFullname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button btnUploadImg;
    @FXML
    private Button btnEditProfile;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnSave;


    private ProfileService profileService;
    //----------------------------------------------------------------------------


    public ProfileController() {
        this.profileService = new ProfileService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setFieldsUneditable();
        setFieldsDefaults();
    }

    private void setFieldsUneditable() {
        txtUserID.setEditable(false);
        txtRole.setEditable(false);
        txtUsername.setEditable(false);
        txtFullname.setEditable(false);
        txtEmail.setEditable(false);
        txtPhone.setEditable(false);
    }

    private void setFieldsEditable() {
        txtFullname.setEditable(true);
        txtEmail.setEditable(true);
        txtPhone.setEditable(true);
    }

    private void setFieldsDefaults() {
        txtUserID.setText(String.valueOf(UserContext.getInstance().getUser_id()));
        txtRole.setText(UserContext.getInstance().getRole());
        txtUsername.setText(UserContext.getInstance().getUsername());
        txtFullname.setText(UserContext.getInstance().getName());
        txtEmail.setText(UserContext.getInstance().getEmail());
        txtPhone.setText(UserContext.getInstance().getPhone());
    }

    public void OnClickEditProfile(ActionEvent actionEvent) {
        setFieldsEditable();
    }

    public void OnClickCancel(ActionEvent actionEvent) {
        setFieldsDefaults();
        setFieldsUneditable();
    }

    public void OnClickSave(ActionEvent actionEvent) {
        // Get user input
        String fullname = txtFullname.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        // Validate user input
        if(fullname.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Please fill all the required fields!");
            return;
        }
        else if (email.compareTo(UserContext.getInstance().getEmail()) != 0 && DoesExistChecker.doesEmailExist(email)) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Email already exists!");
            return;
        }
        else if (phone.compareTo(UserContext.getInstance().getPhone()) != 0 && DoesExistChecker.doesPhoneNumberExist(phone)) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.ERROR,
                    "Error",
                    null,
                    "Phone number already exists!");
            return;
        }

        // Update User Context
        UserContext.getInstance().setName(fullname);
        UserContext.getInstance().setEmail(email);
        UserContext.getInstance().setPhone(phone);

        // Update database
        profileService.updateNameByRole(UserContext.getInstance().getRole(), fullname);
        profileService.updateEmailByRole(UserContext.getInstance().getRole(), email);
        profileService.updatePhoneByRole(UserContext.getInstance().getRole(), phone);

        // Show Confirmation message
        Alert.showAlert(javafx.scene.control.Alert.AlertType.CONFIRMATION,
                "",
                null,
                "Profile updated successfully!");

        setFieldsUneditable();
    }
}
