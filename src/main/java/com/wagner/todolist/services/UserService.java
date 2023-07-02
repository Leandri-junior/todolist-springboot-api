package com.wagner.todolist.services;

import com.wagner.todolist.models.TodoUser;
import com.wagner.todolist.repositories.TaskRepository;
import com.wagner.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public TodoUser findById(Long id){
        Optional<TodoUser> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
                "User not found! id:" + id + ", Type:" + TodoUser.class.getName()
        ));
    }

    @Transactional
    public TodoUser create(TodoUser obj) {
        obj = this.userRepository.save(obj);
        this.taskRepository.saveAll(obj.getTasks());
        return obj;
    }

    @Transactional
    public TodoUser update(TodoUser obj){
        TodoUser newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());

        return this.userRepository.save(newObj);
    }

    public void delete(TodoUser obj){
        TodoUser newObj = findById(obj.getId());
        newObj.setStatus(false);
        this.userRepository.save(newObj);
    }

}

