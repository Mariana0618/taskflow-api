package com.taskflow;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private List<Task> tasks = new ArrayList<>();

    public TasksController() {
        tasks.add(new Task(1L, "Aprender Spring Boot", true));
        tasks.add(new Task(2L, "Crear portafolio", false));
        tasks.add(new Task(3L, "Practicar Git", false));
    }

    // GET /tasks
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // POST /tasks
    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        newTask.setId((long) (tasks.size() + 1)); // cast to Long
        tasks.add(newTask);
        return newTask;
    }

    // PUT /tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getId().equals(id)) {
                t.setTitle(updatedTask.getTitle());
                t.setDescription(updatedTask.getDescription());
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getId().equals(id)) {
                tasks.remove(i);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
