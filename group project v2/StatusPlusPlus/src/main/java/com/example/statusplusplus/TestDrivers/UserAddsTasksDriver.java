/**
 * Driver class for the "Add Tasks" page
 * User is able to filter through categories and select tasks
 */
package com.example.statusplusplus.TestDrivers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The UserAddsTask page. (USE ONLY IN TESTING!)
 */
public class UserAddsTasksDriver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/statusplusplus/Status++UserAddsTasks.fxml"));

        // Set the scene
        Scene scene = new Scene(root);

        // Set the stage title
        primaryStage.setTitle("Add Tasks");

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
