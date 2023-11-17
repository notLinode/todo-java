package com.notlinode.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskBoard {

    private final List<TodoTask> tasks;

    void add(String description) {
        TodoTask task = new TodoTask(description);
        tasks.add(task);
    }

    void add(String description, boolean checked) {
        TodoTask task = new TodoTask(description, checked);
        tasks.add(task);
    }

    void remove(int idx) {
        tasks.remove(idx);
    }

    void check(int idx) {
        TodoTask task = tasks.get(idx);
        task.setChecked(!task.isChecked());
        tasks.set(idx, task);
    }

    TaskBoard() {
        tasks = new ArrayList<>();
    }

    void render() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        tasks.forEach(task -> System.out.printf((task.isChecked() ? "[x] %s\n" : "[ ] %s\n"), task.getDescription()));
    }

}