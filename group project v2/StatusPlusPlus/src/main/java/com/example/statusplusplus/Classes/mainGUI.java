package com.example.statusplusplus.Classes;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.statusplusplus.DatabaseModels.Algorithms;
import com.example.statusplusplus.DatabaseModels.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.statusplusplus.DatabaseModels.Algorithms.getExpThreshold;

/**
 * The mainGUI of our program. The HOME SCREEN!
 */
public class mainGUI {

    @FXML
    private Text skillPointsText;
    @FXML
    private Button strIncrementButton;
    @FXML
    private Button intIncrementButton;
    @FXML
    private Button staIncrementButton;
    @FXML
    private Button wisIncrementButton;
    @FXML
    private Button vitIncrementButton;

    @FXML
    private Text exp;

    @FXML
    private Text intel;

    @FXML
    private Text level;

    @FXML
    private TextArea notes;

    @FXML
    private Button taskPageButton;

    @FXML
    private Text sta;

    @FXML
    private Text str;

    @FXML
    private Text streak;

    @FXML
    private Text task1;

    @FXML
    private Button task1button;

    @FXML
    private Text task2;

    @FXML
    private Button task2button;

    @FXML
    private Text task3;

    @FXML
    private Button task3button;

    @FXML
    private Text task4;

    @FXML
    private Button task4button;

    @FXML
    private Text task5;

    @FXML
    private Button task5button;

    @FXML
    private Text username;

    @FXML
    private Text vit;

    @FXML
    private Text wis;

    private User currUser;
    private UserStats currUStats;
    private SkillLevels skillLevels;
    private final Database db = new Database();
    private ArrayList<Task> tasks;

    @FXML
    void initialize() {
        assert exp != null : "fx:id=\"exp\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert intel != null : "fx:id=\"intel\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert level != null : "fx:id=\"level\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert notes != null : "fx:id=\"notes\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert taskPageButton != null : "fx:id=\"shopOpenButton\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert sta != null : "fx:id=\"sta\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert str != null : "fx:id=\"str\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert streak != null : "fx:id=\"streak\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task1 != null : "fx:id=\"task1\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task1button != null : "fx:id=\"task1button\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task2 != null : "fx:id=\"task2\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task2button != null : "fx:id=\"task2button\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task3 != null : "fx:id=\"task3\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task3button != null : "fx:id=\"task3button\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task4 != null : "fx:id=\"task4\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task4button != null : "fx:id=\"task4button\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task5 != null : "fx:id=\"task5\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert task5button != null : "fx:id=\"task5button\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert vit != null : "fx:id=\"vit\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert wis != null : "fx:id=\"wis\" was not injected: check your FXML file 'Status++GUI.fxml'.";

        setupButtonAction(task1button, 1);
        setupButtonAction(task2button, 2);
        setupButtonAction(task3button, 3);
        setupButtonAction(task4button, 4);
        setupButtonAction(task5button, 5);

        // Setup the increment buttons
        setupIncrementButton(strIncrementButton, TaskCategory.STR);
        setupIncrementButton(intIncrementButton, TaskCategory.INT);
        setupIncrementButton(staIncrementButton, TaskCategory.END);
        setupIncrementButton(wisIncrementButton, TaskCategory.WIS);
        setupIncrementButton(vitIncrementButton, TaskCategory.VIT);

        // Hide the buttons until we want to show them
        strIncrementButton.setVisible(false);
        intIncrementButton.setVisible(false);
        staIncrementButton.setVisible(false);
        wisIncrementButton.setVisible(false);
        vitIncrementButton.setVisible(false);

        // Set up the eventHandler for navigating to the task page.
        taskPageButton.setOnAction(event -> {
            try {
                navToTaskPage();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * A method that is used to assign each of the task complete buttons their action.
     * @param button The button that you want to assign the action to. Type: Button
     * @param taskNumber The taskNumber of the button. Type: Integer
     */
    private void setupButtonAction(Button button, int taskNumber) {
        button.setOnAction(event -> {
            try {
                taskComplete(taskNumber);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * This will just show the UserAddsTask page, along with passing it the userID of the current user.
     */
    private void navToTaskPage(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/statusplusplus/Status++UserAddsTasks.fxml"));
            Parent p = loader.load();

            UserAddsTasks controller = loader.getController();

            // Pass the parent scene and current userID to the task adding page
            controller.receiveUserID(currUser.getUserID());
            controller.setMainStage((Stage) taskPageButton.getScene().getWindow());
            controller.setMainController(this);

            // Make it APPEAR!
            Stage newStage = new Stage();
            newStage.setScene(new Scene(p));
            newStage.setTitle("Add Tasks");
            newStage.setResizable(false);
            newStage.show();

        }catch(Exception e){
            System.out.println("Error navigating to the task page");
        }
    }

    /**
     * A method which is used to assign each of the skill point increment buttons to their actions.
     * @param button The button that you want to assign the action to. Type: Button
     * @param category The taskNumber of the button. Type: Integer
     */
    private void setupIncrementButton(Button button, TaskCategory category) {
        button.setOnAction(event -> {
            try {
                incrementStat(category);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * A method which increments the given stat and updates the view.
     * @param category The category of the incremented stat.
     * @throws SQLException An error accessing or modifying the database.
     */
    private void incrementStat(TaskCategory category) throws SQLException {
        if (currUStats.getSkillPoints() > 0) {
            db.increaseUserStat(currUser.getUserID(), category, 1);
            db.increaseUserSkillPoints(currUser.getUserID(), -1);

            // Update the currUStats object
            switch (category) {
                case STR:
                    skillLevels.setStrength(skillLevels.getStrength() + 1);
                    str.setText(Integer.toString(skillLevels.getStrength()));
                    break;
                case INT:
                    skillLevels.setIntelligence(skillLevels.getIntelligence() + 1);
                    intel.setText(Integer.toString(skillLevels.getIntelligence()));
                    break;
                case END:
                    skillLevels.setEndurance(skillLevels.getEndurance() + 1);
                    sta.setText(Integer.toString(skillLevels.getEndurance()));
                    break;
                case WIS:
                    skillLevels.setWisdom(skillLevels.getWisdom() + 1);
                    wis.setText(Integer.toString(skillLevels.getWisdom()));
                    break;
                case VIT:
                    skillLevels.setVitality(skillLevels.getVitality() + 1);
                    vit.setText(Integer.toString(skillLevels.getVitality()));
                    break;
            }

            // Decrement skill points and update the display
            currUStats.setSkillPoints(currUStats.getSkillPoints() - 1);
            skillPointsText.setText(Integer.toString(currUStats.getSkillPoints()));

            // Hide buttons and skill points text if skill points are 0
            if (currUStats.getSkillPoints() <= 0) {
                strIncrementButton.setVisible(false);
                intIncrementButton.setVisible(false);
                staIncrementButton.setVisible(false);
                wisIncrementButton.setVisible(false);
                vitIncrementButton.setVisible(false);
            }
        }
    }

    /**
     * A function that will set the current user of the page, should also call the setData function
     * to fill in the blank text fields, but it currently needs fixed.
     * @param currUser The user that was gotten from the DB.
     */
    public void setUser(User currUser){
        if(tasks == null){
           tasks = db.getAllUserTasks(currUser.getUserID());
        }

        try {
            this.currUser = currUser;
            this.currUStats = currUser.getStats();
            this.skillLevels = currUStats.getuSkillLevels();

            if (username != null && currUStats != null) {
                setData();
            }
        }catch (Exception e){
            System.out.println("Something went wrong in setUser(): " + e.getMessage());
        }
    }

    /**
     * Should go through all the user skills and levels and fill in the fmxl fields with their values.
     */
    public void setData(){
        int lvl = currUStats.getLevel();
        String threshold = Integer.toString(getExpThreshold(lvl));
        String experience = (currUStats.getExp() + "/" + threshold);
        exp.setText(experience);

        // Fill in the usersname and stats fields
        username.setText(currUser.getUserName());
        level.setText(Integer.toString(lvl));
        str.setText(Integer.toString(skillLevels.getStrength()));
        wis.setText(Integer.toString(skillLevels.getWisdom()));
        vit.setText(Integer.toString(skillLevels.getVitality()));
        intel.setText(Integer.toString(skillLevels.getIntelligence()));
        sta.setText(Integer.toString(skillLevels.getEndurance()));

        // Fill in the skillpoints
        int skillPoints = currUStats.getSkillPoints();
        skillPointsText.setText(Integer.toString(skillPoints));

        // Show skill leveling up buttons if needed.
        boolean showSkillControls = skillPoints > 0;
        strIncrementButton.setVisible(showSkillControls);
        intIncrementButton.setVisible(showSkillControls);
        staIncrementButton.setVisible(showSkillControls);
        wisIncrementButton.setVisible(showSkillControls);
        vitIncrementButton.setVisible(showSkillControls);

        // Display all the users tasks
        displayTasks();
    }

    /**
     * A function used to load in a users tasks from the database.
     * Will throw and catch an out-of-bounds exception if user doesn't have 5 tasks.
     */
    public void displayTasks(){
        try{
            task1.setText(tasks.get(0).getTaskName());
            task2.setText(tasks.get(1).getTaskName());
            task3.setText(tasks.get(2).getTaskName());
            task4.setText(tasks.get(3).getTaskName());
            task5.setText(tasks.get(4).getTaskName());
        }catch(IndexOutOfBoundsException e){
            System.out.println("User didn't have enough tasks to fill all boxes: " + e.getMessage());
        }
    }

    public void loadTasksFromDB(int userID){
        tasks = db.getAllUserTasks(userID);
    }

    private void resetTaskView(){
        String def = "Try adding a new task!";
        task1.setText(def);
        task2.setText(def);
        task3.setText(def);
        task4.setText(def);
        task5.setText(def);
    }

    /**
     * A function that handles when tasks are completed. tries to give user xp, level up if needed, etc
     * @param taskNum The index + 1 of the task. ex. Task 1 button => 1. Integer
     */
    private void taskComplete(int taskNum){
        try {
            Task temp = tasks.get(taskNum - 1);
            int taskID = temp.getTaskId();
            int userID = currUser.getUserID();
            int level = currUStats.getLevel();
            int xpThreshold = getExpThreshold(level);

            System.out.println("Completing task number: " + taskNum);
            // Check get the amount of exp that the task will give
            int expToGive = temp.getExpGained();
            int userXP = currUStats.getExp();

            //Check if the amount of exp given to the user would push the value over threshold
            if(userXP + expToGive >= xpThreshold){
                // Set exp to newXP - levelUpThreshold, then increment user level
                currUStats.setExp(userXP + expToGive - xpThreshold);
                db.increaseUserLevel(userID, 1);
                currUStats.setLevel(level + 1);

                int skPToGive = Algorithms.getSkillPointsGranted(level);
                // apply change to database
                db.increaseUserSkillPoints(userID, skPToGive);
                // apply change locally
                currUStats.setSkillPoints(currUStats.getSkillPoints() + skPToGive);
            }else{
                currUStats.setExp(userXP + expToGive);
            }

            // Update the view since something had to change.
            setData();

            // Try to remove task from db.
            db.removeUserTask(userID, taskID);

            // Reload the local view of the tasks.
            resetTaskView();
            tasks = db.getAllUserTasks(currUser.getUserID());
            displayTasks();
        }
        catch(Exception e){
            System.out.println("Task complete function error: " + e.getMessage());
        }
    }
}


