package com.java_pos_sql.java_pos_sql.controller;

import com.java_pos_sql.java_pos_sql.model.User;
import com.java_pos_sql.java_pos_sql.repository.UserRepository;
import com.java_pos_sql.java_pos_sql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }
}
