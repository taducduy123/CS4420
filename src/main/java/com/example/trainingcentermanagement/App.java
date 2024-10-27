package com.example.trainingcentermanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage stage;
    private static Scene scene;

    //--------------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create a Stage that contains all Scenes
        stage = primaryStage;

        // Create Scene (or Root)
        scene = new Scene(loadFXML("LoginView"));

        // Add the current scene to stage
        primaryStage.setScene(scene);

        // Basic settings (Optional) for stage
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();         // Make stage fit scene

        // Show stage + components inside stage
        primaryStage.show();
    }

    // When we want to change a screen to another screen
    public static void setRootAs(String fxmlPath) throws IOException {
        Parent currentRoot = loadFXML(fxmlPath + ".fxml");
        scene.setRoot(currentRoot);

        // Make stage fit new scene
        stage.setWidth(currentRoot.prefWidth(-1));
        stage.setHeight(currentRoot.prefHeight(-1));

    }

    private static Parent loadFXML(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath + ".fxml"));
        return fxmlLoader.load();
    }
}
