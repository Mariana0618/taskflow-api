package com.taskflow;

public class Task {

    private Long id;           // use Long, not int
    private String title;
    private String description;
    private boolean done;

    // Constructor
    public Task(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.description = ""; // default empty description
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
