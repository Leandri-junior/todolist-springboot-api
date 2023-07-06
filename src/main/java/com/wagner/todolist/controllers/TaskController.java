package com.wagner.todolist.controllers;

import com.wagner.todolist.models.Task;
import com.wagner.todolist.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{id}")
@Validated
public class TaskController {
    private TaskService taskService;
    public ResponseEntity<Task> findById(@PathVariable Long id){
        Task newTask = this.taskService.findById(id);
        return ResponseEntity.ok().body(newTask);
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task obj){
        Task newTask = this.taskService.create(obj);
        return ResponseEntity.ok().body(newTask);
    }

    @PostMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task obj){
        Task newTask = this.taskService.update(obj);
        return ResponseEntity.ok().body(newTask);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id){
        Task newTask = this.taskService.findById(id);
        this.taskService.delete(newTask);
        return ResponseEntity.noContent().build();
    }
}

