package com.example.springcloud.springdatajpa.dao;

import com.example.springcloud.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//不需要为UserDao编写实现，Spring Data Jpa在运行时会创建一个实现
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByUsername(String userName);


}
