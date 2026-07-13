package com.java_pos_sql.java_pos_sql.service;

import com.java_pos_sql.java_pos_sql.model.User;
import com.java_pos_sql.java_pos_sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public Optional<User> singleUser(Long id){
        return userRepository.findById(id);
    }


}
