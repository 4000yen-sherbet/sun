package com.example.rest.service;

import java.util.List;

import com.example.rest.entity.User;

public interface UserService {

    public List<User> selectAll();

    public User findOne(String userId);
    
    public int insert(User user);

    public int update(User user);

    public int delete(String UserId);

    public int count();
    
}