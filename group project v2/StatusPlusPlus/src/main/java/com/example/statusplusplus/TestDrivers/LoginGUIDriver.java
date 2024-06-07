package com.example.statusplusplus.TestDrivers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.statusplusplus.Classes.LoginGUI;
import com.example.statusplusplus.DatabaseModels.Database;

/**
 * This file is responsible for launching the application.
 */
public class LoginGUIDriver extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/statusplusplus/Status++Login.fxml"));
            primaryStage.setTitle("Status++ Login");
            primaryStage.setResizable(false);
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