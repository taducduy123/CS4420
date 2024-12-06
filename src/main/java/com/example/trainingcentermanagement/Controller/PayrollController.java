package com.example.trainingcentermanagement.Controller;

import com.example.trainingcentermanagement.Model.Billing;
import com.example.trainingcentermanagement.Model.Payroll;
import com.example.trainingcentermanagement.Model.Payroll;
import com.example.trainingcentermanagement.Services.BillingService;
import com.example.trainingcentermanagement.Services.PayrollService;
import com.example.trainingcentermanagement.Utils.Alert;
import com.example.trainingcentermanagement.Utils.DoesExistChecker;
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

public class PayrollController implements Initializable {

    @FXML
    private TableView<Payroll> table;
    @FXML
    private TableColumn<Payroll, Integer> instructorID;
    @FXML
    private TableColumn<Payroll, String> fname;
    @FXML
    private TableColumn<Payroll, String> mname;
    @FXML
    private TableColumn<Payroll, String> lname;
    @FXML
    private TableColumn<Payroll, Integer> level;
    @FXML
    private TableColumn<Payroll, Integer> courseID;
    @FXML
    private TableColumn<Payroll, String> courseName;
    @FXML
    private TableColumn<Payroll, Double> rate;
    @FXML
    private TableColumn<Payroll, Integer> numAttend;
    @FXML
    private TableColumn<Payroll, Double> total;
    
    @FXML
    private TextField txtInstructorID;
    @FXML
    private TextField txtTotalSalary;
    @FXML
    private Button btnCalculate;
    
    private PayrollService payrollService;
    private ObservableList<Payroll> list;

    //-------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instructorID.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("instructor_id"));
        fname.setCellValueFactory(new PropertyValueFactory<Payroll, String>("first_name"));
        mname.setCellValueFactory(new PropertyValueFactory<Payroll, String>("middle_name"));
        lname.setCellValueFactory(new PropertyValueFactory<Payroll, String>("last_name"));
        level.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("level"));
        courseID.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("course_id"));
        courseName.setCellValueFactory(new PropertyValueFactory<Payroll, String>("course_name"));
        rate.setCellValueFactory(new PropertyValueFactory<Payroll, Double>("course_rate"));
        numAttend.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("numAttend"));
        total.setCellValueFactory(new PropertyValueFactory<Payroll, Double>("total"));

        txtTotalSalary.setEditable(false);
    }

    public PayrollController() {
        list = FXCollections.observableArrayList();
        payrollService = new PayrollService();
    }

    public void onClickOnCalculateTotalSalary(ActionEvent actionEvent) {
        // Get User Input
        String instructor_id = txtInstructorID.getText().trim();

        // Validate User Input
        if(instructor_id.isEmpty()){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Please enter the instructor ID!");
            return;
        }
        if(!DoesExistChecker.doesInstructorID_EXIST(instructor_id)){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Instructor ID does not exist!");
            return;
        }
        if(!payrollService.checkPayrollExistFor(instructor_id)){
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING,
                    "",
                    null,
                    "Not Found Any Payrolls!");
            return;
        }

        // Clear table view
        this.table.getItems().clear();

        // Load Bills to Table View
        this.list.addAll(payrollService.getPayrollBy(instructor_id));
        this.table.setItems(this.list);

        // Calculate total amount
        double total = 0;
        for(Payroll payroll : list){
            total += payroll.getTotal();
        }

        // Display total amount
        txtTotalSalary.setText(String.valueOf(total));
    }
}