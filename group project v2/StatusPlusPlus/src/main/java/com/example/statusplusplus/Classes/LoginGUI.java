package com.example.statusplusplus.Classes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    private Database databaseManager;

    public void setDatabaseManager(Database dbManager) {
        this.databaseManager = dbManager;
    }

    @FXML
    private void initialize() {
        login.setOnAction(event -> handleLogin());
        createAccount.setOnAction(event -> handleAccountCreation());
    }

    private void handleLogin() {
        String usernameInput = username.getText();
        String passwordInput = password.getText();
        String emailInput = email.getText();
        //System.out.println("Username: " + username + ", Password: " + password);
        boolean validUser databaseManager.checkCredentials(email, password);
        if (validUser) {
            // Close the current stage
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();

            // Load and show the new GUI
            openMainGUI();
        }
    }

    private void handleAccountCreation() {
        String usernameInput = username.getText();
        String emailInput = email.getText();
        String passwordInput = password.getText();

        databaseManager.addUser(usernameInput, emailInput, passwordInput);

        // Close the current stage
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();

        // Load and show the new GUI
        openMainGUI();
    }

    private void openMainGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Status++GUI.fxml"));
            Parent root = loader.load();

            // If the main GUI controller needs the databaseManager, set it here
            mainGUI controller = loader.getController();
            controller.setDatabaseManager(databaseManager);

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Main GUI");
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
