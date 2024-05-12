public class Task {

    // ---- Fields ----

    private int taskId;
    private TaskCategory taskCategory;
    private String taskName;

    // ---- Constructors ----

    /**
     * Constructor for Task class.
     * @param taskId Unique task identifier.
     * @param taskCategory Task category.
     * @param taskName Task name.
     */
    public Task(int taskId, TaskCategory taskCategory, String taskName) {
        this.taskId = taskId;
        this.taskCategory = taskCategory;
        this.taskName = taskName;
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
     * Method to get task category.
     * @return Task category.
     */
    public TaskCategory getCategory() {
        return taskCategory;
    }

    /**
     * Method to get task name.
     * @return Task name.
     */
    public String getName() {
        return taskName;
    }

    @Override
    public String toString() {

        // Build string
        String str =
            "Task ID: " + taskId
            + "\nCategory: " + taskCategory
            + "\nName: " + taskName
        ;

        // Return string
        return str;

    }
}