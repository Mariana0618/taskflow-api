package com.taskflow;

public class Task {
    private int id;
    private String title;
    private boolean completed;

    // Constructor vacío (importante para @RequestBody)
    public Task() {}

    // Constructor completo
    public Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
