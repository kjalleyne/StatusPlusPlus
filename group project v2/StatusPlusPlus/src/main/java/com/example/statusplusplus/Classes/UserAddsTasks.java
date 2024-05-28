/**
 * Class correlated to JavaFX Scene Builder for "Add Tasks" page
 */
package com.example.statusplusplus.Classes;

// classes imported
import com.example.statusplusplus.DatabaseModels.Database;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.text.Text;


public class UserAddsTasks implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Text showingCtgyTaskTF;

    /**
     * Button fields
     */
    @FXML
    private Button homeButton;

    /**
     * Table
     */
    @FXML
    private TableView<Task> tableView;

    /**
     * Table column fields
     */
    @FXML
    private TableColumn<Task, Integer> taskNoCol; // for taskID attribute in db
    @FXML
    private TableColumn<Task, String> descriptionCol; // for taskName attribute in db
    @FXML
    private TableColumn<Task, Integer> expGainedCol; // for expGained attribute in db
    @FXML
    private TableColumn<Task, Integer> categoryCol; // for category attribute in db
    @FXML
    private TableColumn<?, ?> selectCol; // for user to select a task (maybe <Task, Boolean>??)

    // Initializing Database class
    private final Database db = new Database();

    // initializing taskID array list
    ArrayList<Task> taskIDs = db.getAllTaskIDs();

    /**
     * Page initialization, sets combo box and updates combo box
     * and tasks display based on category user selects
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Setting values in combo box
        comboBox.setItems(FXCollections.observableArrayList("All", "Endurance", "Intelligence", "Strength", "Wisdom", "Vitality"));

        // Add a listener to the ComboBox selection property
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newCategory) -> {

            // Update the text of the Text node based on the selected item
            showingCtgyTaskTF.setText("Showing " + newCategory + " Tasks");

            // Calls the display category method to update tasks shown
            displayCategory(newCategory);
        });

        // Converts ArrayList to ObservableList??
        // ObservableList might be needed for inserting the data in Columns?
        /*
        taskIDs = (ArrayList<Task>) FXCollections.observableArrayList(db.getAllTaskIDs());
        tableView.setItems((ObservableList<Task>) taskIDs);
         */

        // set based on field names from Task class
        taskNoCol.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        expGainedCol.setCellValueFactory(new PropertyValueFactory<>("expGained"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("taskCategory"));
        selectCol.setCellValueFactory(new PropertyValueFactory<>("selected"));

        // DELETE LATER - test to get task relation data
        printAllTasks();

    }

    /**
     * Method to display tasks based on category user selected from combo box
     * @param category takes in category of tasks to display
     */
    public void displayCategory(String category) {

        // ...

    }

    /**
     * Action listener for "Confirm Select" button
     * Adds the checked select boxes of tasks that user wants,
     * Puts into userTasks relation
     */


    /**
     * Action listener for "Deselect All" button
     * Deselects all checked select boxes of tasks that user
     * has checked.
     */


    /**
     * DELETE LATER, just to test if the task relation data was grabbed from database
     */
    public void printAllTasks() {
        for (Task task : taskIDs) {
            System.out.println("Task ID: " + task.getId());
            System.out.println("Exp Gained: " + task.getExpGained());
            System.out.println("Task Category: " + task.getCategory());
            System.out.println("Task Name: " + task.getName());
            System.out.println();
        }
    }

    /**
     * When home button is clicked, user goes back to the home page of the program.
     */
    @FXML
    private void goToHomePage() {

        // Trying to load the home page of the application
        try {

            // Load the FXML file for the home page
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/statusplusplus/Status++GUI.fxml"));

            // Create a new scene with the loaded root node
            Scene scene = new Scene(root);

            // Get the stage from the home button
            Stage stage = (Stage) homeButton.getScene().getWindow();

            // Set the new scene on the stage
            stage.setScene(scene);

            // Set the title of the stage to "Home"
            stage.setTitle("Home");

        // catch block if the FXML file not found
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
