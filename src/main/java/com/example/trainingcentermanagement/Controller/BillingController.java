package com.example.trainingcentermanagement.Controller;
import com.example.trainingcentermanagement.Model.Billing;
import com.example.trainingcentermanagement.Services.BillingService;
import com.example.trainingcentermanagement.Utils.Alert;
import com.example.trainingcentermanagement.Utils.DoesExistChecker;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BillingController implements Initializable {
    @FXML
    private TableView<Billing> table;
    @FXML
    private TableColumn<Billing, Integer> studentID;
    @FXML
    private TableColumn<Billing, String> fname;
    @FXML
    private TableColumn<Billing, String> lname;
    @FXML
    private TableColumn<Billing, String> mname;
    @FXML
    private TableColumn<Billing, String> courseID;
    @FXML
    private TableColumn<Billing, String> courseName;
    @FXML
    private TableColumn<Billing, Double> rate;
    @FXML
    private TableColumn<Billing, Integer> numAttend;
    @FXML
    private TableColumn<Billing, Double> total;

    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtTotalAmount;
    @FXML
    private Button btnBill;

    private ObservableList<Billing> list;
    private BillingService billingService;

    //------------------------------------------------------------------------


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentID.setCellValueFactory(new PropertyValueFactory<Billing, Integer>("student_id"));
        fname.setCellValueFactory(new PropertyValueFactory<Billing, String>("first_name"));
        mname.setCellValueFactory(new PropertyValueFactory<Billing, String>("middle_name"));
        lname.setCellValueFactory(new PropertyValueFactory<Billing, String>("last_name"));
        courseID.setCellValueFactory(new PropertyValueFactory<Billing, String>("course_id"));
        courseName.setCellValueFactory(new PropertyValueFactory<Billing, String>("course_name"));
        rate.setCellValueFactory(new PropertyValueFactory<Billing, Double>("course_rate"));
        numAttend.setCellValueFactory(new PropertyValueFactory<Billing, Integer>("numAttend"));
        total.setCellValueFactory(new PropertyValueFactory<Billing, Double>("total"));

        txtTotalAmount.setEditable(false);
    }


    public BillingController() {
        list = FXCollections.observableArrayList();
        billingService = new BillingService();
    }

    public void onClickGenerateBill(ActionEvent actionEvent) {

        // Get User Input
        String student_id = txtStudentID.getText().trim();

        // Validate User Input
        if(student_id.isEmpty()){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Please enter the student ID!");
            return;
        }
        if(!DoesExistChecker.doesStudentID_EXIST(student_id)){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Student ID does not exist!");
            return;
        }
        if(!billingService.checkBillExistFor(student_id)){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Not Found Any Bills!");
            return;
        }

        // Clear table view
        this.table.getItems().clear();

        // Load Bills to Table View
        this.list.addAll(billingService.getBillBy(student_id));
        this.table.setItems(this.list);

        // Calculate total amount
        double total = 0;
        for(Billing bill : list){
            total += bill.getTotal();
        }

        // Display total amount
        txtTotalAmount.setText(String.valueOf(total));
    }



}
