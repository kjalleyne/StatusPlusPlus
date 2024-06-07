package com.example.statusplusplus.TestDrivers;

import com.example.statusplusplus.Classes.*;
import com.example.statusplusplus.DatabaseModels.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.example.statusplusplus.DatabaseModels.Algorithms.getExpThreshold;

/**
 * A file to test the functions we have developed without running the gui.
 */
public class LoginApplication {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Database databaseManager = new Database();

        //Create a default user for demonstration purposes)
        String defaultUserName = "Ethan Roppel";
        String defaultEmail = "ethan@example.com";
        String defaultPassword = "password123";
        databaseManager.addUser(defaultUserName, defaultEmail, defaultPassword);
        System.out.println("Default user created.");

        // User login attempt
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();


        // Check credentials
        if (databaseManager.checkCredentials(email, password)) {
            System.out.println("Login success.");
        } else {
            System.out.println("Login failed.");
        }


        // We will use the enum value for Wisdom
        int categoryID = TaskCategory.STR.getValue();

        // Add a new task to the db
        databaseManager.addTask(65, "Workout",categoryID );

        // Assign the first task in the database to the user with id 1
        databaseManager.assignUserTask(1, 1);

        // Go through and select all tasks of user with id = 1
        List<Task> tasks = databaseManager.getAllUserTasks(1);
        for(Task t: tasks){
            System.out.println(t);
            System.out.println("----------");
        }

        /*
            We will now remove a task from the usertasks associative table, and reprint all the tasks that belong
            to user with id = 1.
         */
        databaseManager.removeUserTask(1, 1);

        tasks = databaseManager.getAllUserTasks(1);
        for(Task t: tasks){
            System.out.println(t);
            System.out.println("----------");
        }

        // Example of how to increase the stats of a user, (userID, increaseByAmount)
        databaseManager.increaseUserStat(1, TaskCategory.INT, 1);
        databaseManager.increaseUserStat(1, TaskCategory.END, 2);
        databaseManager.increaseUserStat(1, TaskCategory.STR, 4);
        databaseManager.increaseUserStat(1, TaskCategory.WIS, 100);
        databaseManager.increaseUserStat(1, TaskCategory.VIT, 10);
        databaseManager.increaseUserSkillPoints(1, 10);
        databaseManager.increaseUserEXP(1, -1001);

        databaseManager.resetUserEXP(1);

        // Example of how to get a skill level of a user.
        // To get other skill levels, use the appropriate enum ex. TaskCategory.WIS, TaskCategory.STR, etc
        int stat = databaseManager.getSkillLevel(1, TaskCategory.VIT);
        System.out.println(stat);

        for(int i = 0; i < 20; i++){
            System.out.println(i + ": " + getExpThreshold(i));
        }
        scanner.close();
    }
}