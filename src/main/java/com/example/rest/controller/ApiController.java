package com.example.rest.controller;

import java.util.List;

import com.example.rest.entity.User;
import com.example.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @GetMapping("/rest/get")
    public List<User> getUserList() {
        System.out.println("メソッド呼び出し:getUserList");
        return userService.selectAll();
    }

    @GetMapping("/rest/get/{id:.+}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.findOne(userId);
    }

    @PostMapping("/rest/insert")
    public String postInsert(@RequestBody User user) {
        int result = userService.insert(user);
        if (result == 1) {
            return "{\"result\":\"ok\"}";
        } else {
            return "{\"result\":\"ng\"}";
        }
    }
}