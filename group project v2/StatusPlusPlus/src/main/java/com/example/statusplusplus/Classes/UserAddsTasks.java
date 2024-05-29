/**
 * Class correlated to JavaFX Scene Builder for "Add Tasks" page
 */
package com.example.statusplusplus.Classes;

// classes imported
import com.example.statusplusplus.DatabaseModels.Database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @FXML
    private Button conSelected;

    @FXML
    private Button deSelected;

    /**
     * Table
     */
    @FXML
    private TableView<TaskWrapper> tableView;

    /**
     * Table column fields
     */
    @FXML
    private TableColumn<TaskWrapper, Integer> taskNoCol; // for taskID attribute in db
    @FXML
    private TableColumn<TaskWrapper, String> descriptionCol; // for taskName attribute in db
    @FXML
    private TableColumn<TaskWrapper, Integer> expGainedCol; // for expGained attribute in db
    @FXML
    private TableColumn<TaskWrapper, Integer> categoryCol; // for category attribute in db
    @FXML
    private TableColumn<TaskWrapper, Boolean> selectCol; // for user to select a task (maybe <Task, Boolean>??)

    private Stage mainStage;
    private int userID;

    // Initializing Database class
    private final Database db = new Database();

    // initializing taskID array list
    private final ArrayList<Task> taskIDs = db.getAllTaskIDs();
    private ObservableList<TaskWrapper> taskWrapperList;

    /**
     * Page initialization, sets combo box and updates combo box
     * and tasks display based on category user selects
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskWrapperList = FXCollections.observableArrayList();
        for (Task task : taskIDs) {
            taskWrapperList.add(new TaskWrapper(task));
        }

        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newCategory) -> {
            showingCtgyTaskTF.setText("Showing " + newCategory + " Tasks");
            displayCategory(newCategory);
        });

        tableView.setItems(taskWrapperList);

        taskNoCol.setCellValueFactory(new PropertyValueFactory<>("taskId"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        expGainedCol.setCellValueFactory(new PropertyValueFactory<>("expGained"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("taskCategory"));
        selectCol.setCellValueFactory(cellData -> cellData.getValue().getSelectedProperty());

        selectCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectCol));

        comboBox.setItems(FXCollections.observableArrayList("All", "Endurance", "Intelligence", "Strength", "Wisdom", "Vitality"));

        conSelected.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Login button clicked");
                handleTasks();
            }
        });

        // DELETE LATER - test to get task relation data
        printAllTasks();
    }

    public void handleTasks() {
        
    }

    /**
     * A function to recieve the userID of the user who clicked on this page from the mainGUI.
     * Assigns value to this.userID, which will be used when adding the tasks to the users.
     * @param userID The user ID of the user who clicked on the task page. Type: Integer
     */
    public void receiveUserID(int userID){
        this.userID = userID;
        System.out.println("Received the userID from mainGUI: " + this.userID);
    }

    /**
     * A function used to keep track of the parent of this page.
     * @param mainStage The stage to return to when we press home button. Type: Stage
     */
    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
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
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Exp Gained: " + task.getExpGained());
            System.out.println("Task Category: " + task.getTaskCategory());
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println();
        }
    }

    /**
     * When home button is clicked, user goes back to the home page of the program.
     */
    @FXML
    private void goToHomePage() {

        Stage stage = (Stage) homeButton.getScene().getWindow();
        stage.close();

        if(mainStage != null){
            mainStage.show();
        }
    }
}
