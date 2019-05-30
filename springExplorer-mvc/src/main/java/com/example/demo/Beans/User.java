package com.example.demo.Beans;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String name;

    private String pwd;

    private Date birth;
}
