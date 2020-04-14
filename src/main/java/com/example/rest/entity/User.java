package com.example.rest.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private int age;
    private boolean marriage;
    private String role;

}