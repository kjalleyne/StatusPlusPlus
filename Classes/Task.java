package Classes;

/**
 * Class for a task object
 */
public class Task {

    // ---- Fields ----

    private int taskId;
    private TaskCategory taskCategory;
    private String taskName;

    private int expGained;

    // ---- Constructors ----

    /**
     * Constructor for Task class.
     * @param taskId Unique task identifier.
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