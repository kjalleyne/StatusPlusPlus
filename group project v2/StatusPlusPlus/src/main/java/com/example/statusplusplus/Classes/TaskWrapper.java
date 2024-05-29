package com.example.statusplusplus.Classes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TaskWrapper {

    private Task task;
    private BooleanProperty selected;

    public TaskWrapper(Task task) {
        this.task = task;
        this.selected = new SimpleBooleanProperty(false); // default value is false
    }

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