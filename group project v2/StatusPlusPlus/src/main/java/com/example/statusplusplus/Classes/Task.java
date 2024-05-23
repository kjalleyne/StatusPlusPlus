package com.example.statusplusplus.Classes;

/**
 * Class for a task object
 */
public class Task {

    // ---- Fields ----

    private int taskId, expGained;
    private TaskCategory taskCategory;
    private String taskName;

    // ---- Constructors ----

    /**
     * Constructor for Task class.
     * @param taskId Unique task identifier.
     * @param expGained Experienced granted.
     * @param taskCategory Task category.
     * @param taskName Task name.
     */
    public Task(int taskId, int expGained, TaskCategory taskCategory, String taskName) {
        this.taskId = taskId;
        this.taskCategory = taskCategory;
        this.taskName = taskName;
        this.expGained = expGained;
    }

    // ---- Methods ----

    /**
     * Method to get task ID.
     * @return Task ID.
     */
    public int getId() {
        return taskId;
    }

    /**
     * Method to set the task ID.
     * @param id Task ID.
     */
    public void setId(int id) {
        taskId = id;
    }

    /**
     * Method to get experience gained.
     * @return Gained experience.
     */
    public int getExpGained() {
        return expGained;
    }

    /**
     * Method to set experience gained.
     * @param expGained Gained experience.
     */
    public void setExpGained(int expGained) {
        this.expGained = expGained;
    }

    /**
     * Method to get task category.
     * @return Task category.
     */
    public TaskCategory getCategory() {
        return taskCategory;
    }

    /**
     * Method to set task category.
     * @param category Task category.
     */
    public void setCategory(TaskCategory category) {
        taskCategory = category;
    }

    /**
     * Method to get task name.
     * @return Task name.
     */
    public String getName() {
        return taskName;
    }

    /**
     * Method to set task name.
     * @param name Task name.
     */
    public void setName(String name) {
        taskName = name;
    }

    @Override
    public String toString() {

        // Build string
        String str =
            "Task ID: " + taskId
            + "\nCategory: " + taskCategory
            + "\nName: " + taskName
            + "\nExp Gained: " + expGained
        ;

        // Return string
        return str;

    }
}