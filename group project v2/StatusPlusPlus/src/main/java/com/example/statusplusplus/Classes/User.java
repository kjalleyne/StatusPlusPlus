package com.example.statusplusplus.Classes;

/**
 * This class defines a user of this application, they have a id, name, stats, and streak boolean.
 */
public class User {
    private String userName;
    private int userID;
    private UserStats stats;
    private boolean isOnStreak;

    /**
     * Constructor for the Use class
     * @param userName The userName of the user: String
     * @param userID Should be a database AI userID: Integer
     * @param stats The stats of the user: UserStats
     * @param isOnStreak Wether the user is on a streak: Boolean
     */
    public User(String userName, int userID, UserStats stats, boolean isOnStreak) {
        this.userName = userName;
        this.userID = userID;
        this.stats = stats;
        this.isOnStreak = isOnStreak;
    }

    /**
     * Prints the fields of the user object it is called on.
     * @return String.
     */
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userID=" + userID +
                ", stats=" + stats +
                ", isOnStreak=" + isOnStreak +
                '}';
    }

    /**
     * Gets the userName of a user.
     * @return String userName.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Function to set the name of a user
     * @param userName The String name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Function to get the userID of a user.
     * @return Integer userID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Function to set the userID of a user.
     * @param userID Integer.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Function to get the stats of a user
     * @return UserStats stats.
     */
    public UserStats getStats() {
        return stats;
    }

    /**
     * Function to set the stats of the user.
     * @param stats UserStats object.
     */
    public void setStats(UserStats stats) {
        this.stats = stats;
    }

    /**
     * Function to check if user is on a streak.
     * @return Boolean.
     */
    public boolean isOnStreak() {
        return isOnStreak;
    }

    /**
     * Function to set the streak feature
     * @param onStreak boolean. Wether user is on streak.
     */
    public void setOnStreak(boolean onStreak) {
        isOnStreak = onStreak;
    }
}
