package com.example.rest.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.rest.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserDomainImpl")
public class UserDomainImpl implements UserDomain {

    @Autowired
    private JdbcTemplate jdbc;

    private String COUNT_SQL = "SELECT COUNT(*) FROM m_user";
    private String SELECT_SQL = "SELECT * FROM m_user";
    private String SELECT_ONE_SQL = "SELECT * FROM m_user WHERE user_id = ?";
    private String INSERT_SQL = "INSERT INTO m_user(" + " user_id, " + " password, " + " user_name, " + " birthday, "
            + " age, " + " marriage, " + " role)" + " VALUES(?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE m_user SET password = ?, user_name = ?, birthday = ?, age = ?, marriage = ? WHERE user_id = ?";
    private String DELETE_SQL = "DELETE FROM m_user WHERE user_id = ?";

    @Override
    public int count() throws DataAccessException {
        return jdbc.queryForObject(COUNT_SQL, Integer.class);
    }

    @Override
    public int delete(String userId) throws DataAccessException {
        return jdbc.update(DELETE_SQL, userId);
    }

    @Override
    public int insert(User user) throws DataAccessException {
        return jdbc.update(INSERT_SQL, user.getUserId(), user.getPassword(), user.getUserName(), user.getBirthday(),
                user.getAge(), user.isMarriage(), user.getRole());
    }

    @Override
    public List<User> selectAll() throws DataAccessException {
        System.out.println("UserDomainImpl#selectAll");
        List<User> userList = new ArrayList<>();
        List<Map<String, Object>> selectList = jdbc.queryForList(SELECT_SQL);

        for (Map<String, Object> map : selectList) {
            User user = new User();
            user.setUserId((String) map.get("user_id"));
            user.setPassword("");
            user.setUserName((String) map.get("user_name"));
            user.setBirthday((Date) map.get("birthday"));
            user.setAge((Integer) map.get("age"));
            user.setMarriage((Boolean) map.get("marriage"));
            user.setRole((String) map.get("role"));
            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public User selectOne(String userId) throws DataAccessException {
        User user = new User();

        Map<String, Object> map = jdbc.queryForMap(SELECT_ONE_SQL, userId);
        user.setUserId((String) map.get("user_id"));
        return user;
    }

    @Override
    public int update(User user) throws DataAccessException {
        return jdbc.update(UPDATE_SQL, user.getPassword(), user.getUserName(), user.getBirthday(), user.getAge(),
                user.isMarriage(), user.getUserId());
    }

}