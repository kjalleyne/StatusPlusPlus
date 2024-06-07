package com.example.statusplusplus.Classes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * This class plays as a Wrapper of Task. It is used in the UserAddsTasks page.
 */
public class TaskWrapper {

    private Task task;
    private BooleanProperty selected;

    /**
     * Constructor for the Wrapper
     * @param task Task to wrap.
     */
    public TaskWrapper(Task task) {
        this.task = task;
        this.selected = new SimpleBooleanProperty(false); // default value is false
    }

    // ========================================
    // Getters and setter only here to appease a function that relates to the JavaFX
    // checkboxes that tie their state to the TaskWrapper BooleanProperty field.
    // Basic getters and setters, thus no javaDocs
    // ========================================
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public BooleanProperty getSelectedProperty() {
        return selected;
    }

    public int getTaskId() {
        return task.getTaskId();
    }

    public int getExpGained() {
        return task.getExpGained();
    }

    public TaskCategory getTaskCategory() {
        return task.getTaskCategory();
    }

    public String getTaskName() {
        return task.getTaskName();
    }
}