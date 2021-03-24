package com.springcloud.springbootsecurity.dao;

import com.springcloud.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
