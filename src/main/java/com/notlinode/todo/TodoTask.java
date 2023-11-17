package com.notlinode.todo;

public class TodoTask {

    private String description;
    private boolean checked;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    TodoTask(String description) {
        this.description = description;
        checked = false;
    }

    TodoTask(String description, boolean checked) {
        this.description = description;
        this.checked = checked;
    }

}