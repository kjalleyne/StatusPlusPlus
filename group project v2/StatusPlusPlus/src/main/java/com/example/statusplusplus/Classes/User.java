package com.example.statusplusplus.Classes;

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



    /*
        Getters and setters for the User fields.
     */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserStats getStats() {
        return stats;
    }

    public void setStats(UserStats stats) {
        this.stats = stats;
    }

    public boolean isOnStreak() {
        return isOnStreak;
    }

    public void setOnStreak(boolean onStreak) {
        isOnStreak = onStreak;
    }
}
