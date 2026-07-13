package com.java_pos_sql.java_pos_sql.controller;

import com.java_pos_sql.java_pos_sql.model.User;
import com.java_pos_sql.java_pos_sql.repository.UserRepository;
import com.java_pos_sql.java_pos_sql.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationContoller {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody User user){
        Authentication  authentication = authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        assert userDetails != null;
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody User user){
        if(userRepository.existsByUsername(user.getUsername())){
            return "User already exists!";
        }

        final User newUser = new User(
                null,
                user.getUsername(),
                passwordEncoder.encode(user.getPassword())
        );
        userRepository.save((newUser));
        return "User registered successfully!";
    }
}
