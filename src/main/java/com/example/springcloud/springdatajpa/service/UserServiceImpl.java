package com.example.springcloud.springdatajpa.service;


import com.example.springcloud.springdatajpa.dao.UserDao;
import com.example.springcloud.springdatajpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userRepository;

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<User> findByQbe(String userName) {
        User condition = new User();
        condition.setUsername(userName);
        return userRepository.findAll(Example.of(condition));
    }

    @Override
    public Long save(String userName, String password) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        User userAfterSave =  userRepository.save(user);
        return userAfterSave.getId();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }
}
