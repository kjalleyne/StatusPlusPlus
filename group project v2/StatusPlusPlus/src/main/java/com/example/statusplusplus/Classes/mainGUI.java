package com.example.statusplusplus.Classes;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.statusplusplus.DatabaseModels.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import static com.example.statusplusplus.DatabaseModels.Algorithms.getExpThreshold;


public class mainGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text exp;

    @FXML
    private Text intel;

    @FXML
    private Text level;

    @FXML
    private TextArea notes;

    @FXML
    private Button shopOpenButton;

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
    private Database db = new Database();
    @FXML
    void initialize() {
        assert exp != null : "fx:id=\"exp\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert intel != null : "fx:id=\"intel\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert level != null : "fx:id=\"level\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert notes != null : "fx:id=\"notes\" was not injected: check your FXML file 'Status++GUI.fxml'.";
        assert shopOpenButton != null : "fx:id=\"shopOpenButton\" was not injected: check your FXML file 'Status++GUI.fxml'.";
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

    }

    /**
     * A function that will set the current user of the page, should also call the setData function
     * to fill in the blank text fields, but it currently needs fixed.
     * @param currUser The user that was gotten from the DB.
     */
    public void setUser(User currUser){
        //username.setText(currUser.getUserName());
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
        ArrayList<Task> tasks = db.getAllUserTasks(currUser.getUserID());

        username.setText(currUser.getUserName());
        String experience = (currUStats.getExp() + "/" + threshold);

        exp.setText(experience);
        level.setText(Integer.toString(lvl));
        str.setText(Integer.toString(skillLevels.getStrength()));
        wis.setText(Integer.toString(skillLevels.getWisdom()));
        vit.setText(Integer.toString(skillLevels.getVitality()));

        task1.setText(tasks.get(0).getName());
        task2.setText(tasks.get(1).getName());
        task3.setText(tasks.get(2).getName());
        task4.setText(tasks.get(3).getName());
        task5.setText(tasks.get(4).getName());
    }

}
