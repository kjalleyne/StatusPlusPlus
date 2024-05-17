import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    /**
     * The required strings for accessing the database.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/380Project"; 
    private static final String USERNAME = "root";
    private static final String PASSWORD = "cs380";

    /**
     * Connects to the database.
     *
     * @return A connection object which represents the database connection.
     * @throws SQLException thrown when there is an error accessing the database.
     */
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Adds a user to the database.
     */
    public void addUser(String userName, String email, String password) throws SQLException {
        String sql = "INSERT INTO users (userName, email, password) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }

    /**
     * Updates the user.
     *
     * @param userID The ID of the user.
     * @param userName The name of the user.
     * @param email The email of the user.
     * @param password The password of the user.
     * @throws SQLException Thrown when there is an error accessing the database.
     */
    public void updateUser(int userID, String userName, String email, String password) throws SQLException {
        String sql = "UPDATE users SET userName = ?, email = ?, password = ? WHERE userID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setInt(4, userID);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with ID: " + userID);
            }
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    /**
     * Deletes a user from the database.
     *
     * @param userID The id of the user.
     * @throws SQLException Thrown when there is an error accessing the database.
     */
    public void deleteUser(int userID) throws SQLException {
        String sql = "DELETE FROM users WHERE userID = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with ID: " + userID);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    /**
     * Prints all the users.
     *
     * @throws SQLException Thrown when there is an error accessing the database.
     */
    public void printUsers() throws SQLException {
        String sql = "SELECT userID, userName, email, password FROM users"; // Include password if necessary for verification (not recommended to print passwords)
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("UserID: " + rs.getInt("userID") + ", UserName: " + rs.getString("userName") + ", Email: " + rs.getString("email") + ", Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }

    /**
     * Checks the credentials of the user.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @return The result of comparing the input strings to the database, true or false depending on if they match.
     * @throws SQLException
     */
    public boolean checkCredentials(String email, String password) throws SQLException {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(password);
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Error checking credentials: " + e.getMessage());
            return false;
        }
    }

    /**
     * Adds a new Task to the database.
     * @param expGained The amount of exp gained by completing the task. Type: Integer
     * @param taskName  The name of the task (must be unique, or this will fail). Type: String
     * @param category The category number of the task. Type: Integer
     */
    public void addTask(int expGained, String taskName, int category){
        String sql = "INSERT INTO tasks (expGained, taskName, category) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, expGained);
            pstmt.setString(2, taskName);
            pstmt.setInt(3, category);
            pstmt.executeUpdate();
            System.out.println("Task added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void assignUserTask(int userID, int taskID){
        String sql = "INSERT INTO usertasks (userIDTasks, taskID) VALUES (?,?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, taskID);
            pstmt.executeUpdate();
            System.out.println("Added task to user-tasks table!");
        } catch (SQLException e) {
            System.out.println("Error adding to user-tasks table: " + e.getMessage());
        }
    }


    /**
     * A function to get all of the tasks for a user.
     * @param userID The userID of the user you are trying to get the task list of. Type: Integer
     * @return  List of Tasks that belong to the user.
     */
    public List<Task> getAllUserTasks(int userID){
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT tasks.* " +
                "FROM tasks " +
                "JOIN userTasks ON tasks.taskID = userTasks.taskID " +
                "WHERE userTasks.userIDTasks = ?";
        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, userID);
            System.out.println("Successfully retrieved users tasks. Returning as ResultSet. ");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                // Get all the fields of a task
                int id = rs.getInt("taskID");
                int xp = rs.getInt("expGained");
                String name = rs.getString("taskName");
                int catVal = rs.getInt("category");
                TaskCategory category = TaskCategory.fromInt(catVal);

                // Try to rebuild the task
                Task t = new Task(id, xp,category ,name);

                // Add the task to the result list
                tasks.add(t);
            }
        }catch (SQLException e){
            System.out.println("Failed to retrieve users tasks: " + e.getMessage());
        }

        return tasks;
    }

    public void removeUserTask(){

    }
}
