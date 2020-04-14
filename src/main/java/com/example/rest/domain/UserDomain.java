package com.example.rest.domain;

import java.util.List;

import com.example.rest.entity.User;

import org.springframework.dao.DataAccessException;

public interface UserDomain {
    public List<User> selectAll() throws DataAccessException;

    public User selectOne(String userId) throws DataAccessException;

    public int insert(User user) throws DataAccessException;

    public int update(User user) throws DataAccessException;

    public int delete(String userId) throws DataAccessException;

    public int count() throws DataAccessException;
}