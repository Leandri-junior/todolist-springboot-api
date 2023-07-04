package com.wagner.todolist.controllers;

import com.wagner.todolist.models.TodoUser;
import com.wagner.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<TodoUser> findById(@PathVariable Long id){
        TodoUser userObj = this.userService.findById(id);
        return ResponseEntity.ok().body(userObj);
    }


}
