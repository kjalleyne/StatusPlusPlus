package Classes;

/**
 * Enum class containing task categories. Also used for searching skill levels from database
 */
public enum TaskCategory {
    INT(1, "intelligence"),
    STR(2, "strength"),
    END(3, "endurance"),
    WIS(4, "wisdom"),
    VIT(5, "vitality");

    private final int value;
    private final String string;

    /**
     * Private constructor, needed for assignment of Enum value directly.
     * Needed to do this to match the database 1 based indexing.
     * @param value The int assigned to the enum
     */
    TaskCategory(int value, String string) {
        this.value = value;
        this.string = string;
    }

    /**
     * The method we can use to get the value of the enum
     * @return Value of enum. Type: Integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to get String version of category.
     * @return String version of category.
     */
    public String getString() {
        return string;
    }

    /**
     * Used to get the proper enum from an int. Used in DB models to build tasks with id of type int stored in DB
     * that int needs to be made into one of these enums.
     * @param value The value of the category. Type: Int
     * @return The taskCategory that the value is equal to.
     * @throws IllegalArgumentException If the value is outside of enum domain, this is thrown.
     */
    public static TaskCategory fromInt(int value) throws IllegalArgumentException {
        for (TaskCategory category : TaskCategory.values()) {
            if (category.getValue() == value) {
                return category;
            }
        }

        throw new IllegalArgumentException("Invalid TaskCategory value: " + value);
    }
}
