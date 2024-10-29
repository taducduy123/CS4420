package com.example.trainingcentermanagement.Controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public ListView<String> lstMenu;
    public AnchorPane contentPane;


    //----------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lstMenu.getItems().addAll("Profile", "Instructor", "Student", "Course"); // them menu

        lstMenu.getSelectionModel().selectFirst(); // chon menu dau tien => menu1 //

        loadPane(lstMenu.getSelectionModel().getSelectedItem()); // loadPane("menu1")
    }

    private void loadPane(String selectedItem) {
        String frm = "";

        switch (selectedItem) {
            case "Menu 1":
                frm = "/com/example/trainingcentermanagement/Menu1View.fxml";
                break;

            case "Menu 2":
                frm = "/com/example/trainingcentermanagement/Menu2View.fxml";
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


}
