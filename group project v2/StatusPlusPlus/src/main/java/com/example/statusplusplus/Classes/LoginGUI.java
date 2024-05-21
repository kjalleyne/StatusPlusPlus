package com.example.statusplusplus.Classes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.statusplusplus.DatabaseModels.*;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginGUI {

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private Button createAccount;

    @FXML
    private Button login;

    private Database databaseManager = new Database();

    public void setDatabaseManager(Database dbManager) {
        this.databaseManager = dbManager;
    }

    @FXML
    private void initialize() {
        login.setOnAction(event -> {
            try {
                handleLogin();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        createAccount.setOnAction(event -> {
            try {
                handleAccountCreation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void handleLogin() throws SQLException {
        String usernameInput = username.getText();
        String passwordInput = password.getText();
        String emailInput = email.getText();
        //System.out.println("Username: " + username + ", Password: " + password);
        boolean validUser = databaseManager.checkCredentials(emailInput, passwordInput);
        if (validUser) {
            // Close the current stage
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();

            // Load and show the new GUI
            openMainGUI();
        }
    }

    private void handleAccountCreation() throws SQLException {
        String usernameInput = username.getText();
        String emailInput = email.getText();
        String passwordInput = password.getText();

        boolean validUser = databaseManager.checkCredentials(emailInput, passwordInput);
        if (validUser) {
            // Close the current stage
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();

            // Load and show the new GUI
            openMainGUI();
        }
        else {
            databaseManager.addUser(usernameInput, emailInput, passwordInput);

            // Close the current stage
            Stage stage = (Stage) login.getScene().getWindow();
            stage.close();

            // Load and show the new GUI
            openMainGUI();
        }
    }

    private void openMainGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Status++GUI.fxml"));
            Parent root = loader.load();

            // If the main GUI controller needs the databaseManager, set it here
            mainGUI controller = loader.getController();
            //controller.setDatabaseManager(databaseManager);

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Main GUI");
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
