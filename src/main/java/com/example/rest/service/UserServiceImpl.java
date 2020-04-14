package com.example.rest.service;

import java.util.List;

import com.example.rest.domain.UserDomain;
import com.example.rest.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("UserDomainImpl")
    private UserDomain domain;

    @Override
    public int delete(String userId) {
        return domain.delete(userId);
    }

    @Override
    public User findOne(String userId) {
        return domain.selectOne(userId);
    }

    @Override
    public int insert(User user) {
        return domain.insert(user);
    }

    @Override
    public List<User> selectAll() {
        return domain.selectAll();
    }

    @Override
    public int update(User user) {
        return domain.update(user);
    }

    @Override
    public int count() {
        return domain.count();
    }
}