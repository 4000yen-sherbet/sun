package com.example.rest.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.rest.entity.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class UserDomainImplTest {

    @Autowired
    @Qualifier("UserDomainImpl")
    private UserDomain domain;

    @BeforeEach
    public void setup() {

    }


    @Test
    @Sql({"sql/m_user-delete.sql","sql/m_user-insert.sql"})
    public void testGetCount() {
        int count = domain.count();

        assertEquals(Integer.valueOf(1), count, "あ");

    }

    @Test
    @Sql({"sql/m_user-delete.sql","sql/m_user-insert.sql"})
    public void testGetUserList() {
        List<User> list = domain.selectAll();

        assertEquals(Integer.valueOf(1), list.size(), "い");

    }
}