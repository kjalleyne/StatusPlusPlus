package com.example.statusplusplus.TestDrivers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.statusplusplus.Classes.LoginGUI;
import com.example.statusplusplus.DatabaseModels.Database;

public class LoginGUIDriver extends Application {

    private Database databaseManager = new Database();

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/statusplusplus/Status++Login.fxml"));
            Parent root = loader.load();

            // Get the controller instance from the loader
            LoginGUI loginController = new LoginGUI();

            // Set the database manager in the controller
            loginController.setDatabaseManager(databaseManager);

            // Set up the stage
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}