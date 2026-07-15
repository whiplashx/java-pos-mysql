package com.java_pos_sql.java_pos_sql.repository;

import com.java_pos_sql.java_pos_sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    boolean existsByUsername(String username);
    
}
