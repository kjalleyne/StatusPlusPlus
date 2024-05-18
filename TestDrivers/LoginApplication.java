package TestDrivers;

import Classes.Task;
import Classes.TaskCategory;
import DatabaseModels.Database;
import Classes.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
        databaseManager.increaseUserINT(1, 1);
        databaseManager.increaseUserEND(1, 2);
        databaseManager.increaseUserSTR(1, 4);
        databaseManager.increaseUserWIS(1, 100);
        databaseManager.increaseUserVIT(1, 10);
        databaseManager.increaseUserSkillPoints(1, 10);
        databaseManager.increaseUserEXP(1, -1001);

        databaseManager.resetUserEXP(1);

        scanner.close();
    }
}