package com.example.rest.entity;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
public class User extends BaseEntity {

    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private int age;
    private boolean marriage;
    private String role;

}