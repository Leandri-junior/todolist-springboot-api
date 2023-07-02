package com.wagner.todolist.services;

import com.wagner.todolist.models.Task;
import com.wagner.todolist.models.TodoUser;
import com.wagner.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
            "Task not found! id: " + id + ", Type: " + Task.class.getName()
        ));
    }

    @Transactional
    public Task create(Task obj){

        TodoUser user = this.userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        obj = this.taskRepository.save(obj);

        return obj;
    }

    public Task update(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    public void delete(Task obj){
        Task newObj = findById(obj.getId());
        newObj.setStatus(false);
        this.taskRepository.save(newObj);

    }
}
