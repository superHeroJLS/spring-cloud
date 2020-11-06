package com.example.springcloud.springdatajpa.controller;

import com.example.springcloud.springdatajpa.entity.User;
import com.example.springcloud.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SpringBoot整合Spring-Data-Jpa
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findByUsername/{userName}")
    public List<User> findByUsername(@PathVariable("userName")String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping("/save/{userName}")
    public Long save(@PathVariable("userName")String userName) {
        return userService.save(userName, "123456");
    }

    @GetMapping("/findByQbe/{userName}")
    public List<User> findByQbe(@PathVariable("userName")String userName) {
        return userService.findByQbe(userName);
    }

}
