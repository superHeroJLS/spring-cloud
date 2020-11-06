package com.example.springcloud.springdatajpa.service;

import com.example.springcloud.springdatajpa.entity.User;

import java.util.List;

public interface UserService {

    List<User> findByUserName(String UserName);

    /**
     * QBE查询
     * @param userName
     * @return
     */
    List<User> findByQbe(String userName);

    List<User> findAll();

    Long save(String userName, String passWord);

    User findById(Long id);

    void updateUser(User user);

    void deleteById(Long id);



}
