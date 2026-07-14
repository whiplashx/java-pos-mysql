package com.java_pos_sql.java_pos_sql.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    @Setter
    @Column(nullable = false)
    private String password;


    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


}
