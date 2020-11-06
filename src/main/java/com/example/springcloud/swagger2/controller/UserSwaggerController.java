package com.example.springcloud.swagger2.controller;

import com.example.springcloud.springdatajpa.entity.User;
import com.example.springcloud.springdatajpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * SpringBoot整合Spring-Data-Jpa
 */
@Api
@RestController
@RequestMapping("userSwagger")
public class UserSwaggerController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/findByUsername/{userName}")
    public List<User> findByUsername(@PathVariable("userName")String userName) {
        return userService.findByUserName(userName);
    }

    @ApiOperation(value = "QBE查询用户信息", notes = "QBE查询用户信息")
    @GetMapping("/findByQbe/{userName}")
    public List<User> findByQbe(@PathVariable("userName")String userName) {
        return userService.findByQbe(userName);
    }

    @ApiOperation(value = "用户信息", notes = "根据用户id查询", httpMethod = "GET", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query", dataTypeClass = Long.class)
    })
    @GetMapping("/findById")
    public User findById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "所有用户", notes = "所有用户信息")
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @GetMapping("/save/{userName}")
    public Long save(@PathVariable("userName")String userName) {
        return userService.save(userName, "123456");
    }

    @ApiOperation(value = "更新用户", notes = "更新用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "body", value = "用户信息", paramType = "body", required = true, dataTypeClass = User.class)
    })
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Long id) {
        userService.deleteById(id);
    }

    @ApiIgnore
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }
}
