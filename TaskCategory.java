/**
 * Enum class containing task categories
 */
public enum TaskCategory {
    INT(1),
    STR(2),
    END(3),
    WIS(4),
    VIT(5);

    private final int value;

    /**
     * Private constructor, needed for assignment of Enum value directly.
     * Needed to do this to match the database 1 based indexing.
     * @param value The int assigned to the enum
     */
    TaskCategory(int value) {
        this.value = value;
    }

    /**
     * The method we can use to get the value of the enum
     * @return Value of enum. Type: Integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Used to get the proper enum from an int. Used in DB models to build tasks with id of type int stored in DB
     * that int needs to be made into one of these enums.
     * @param value The value of the category. Type: Int
     * @return The taskCategory that the value is equal to.
     * @throws IllegalArgumentException If the value is outside of enum domain, this is thrown.
     */
    public static TaskCategory fromInt(int value) {
        for (TaskCategory category : TaskCategory.values()) {
            if (category.getValue() == value) {
                return category;
            }
        }

        throw new IllegalArgumentException("Invalid TaskCategory value: " + value);
    }
}
