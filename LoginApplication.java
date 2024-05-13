import java.sql.SQLException;
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

        scanner.close();
    }
}