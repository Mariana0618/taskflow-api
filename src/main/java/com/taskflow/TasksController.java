package com.taskflow;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private List<Task> tasks = new ArrayList<>();

    public TasksController() {
        tasks.add(new Task(1, "Aprender Spring Boot", true));
        tasks.add(new Task(2, "Crear portafolio", false));
        tasks.add(new Task(3, "Practicar Git", false));
    }

    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        newTask.setId(tasks.size() + 1);
        tasks.add(newTask);
        return newTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(updatedTask.getTitle());
                task.setCompleted(updatedTask.isCompleted());
                return task;
            }
        }
        return null; // o lanzar excepción 404
    }
    
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) return "Task deleted successfully";
        else return "Task not found";
    }


}
