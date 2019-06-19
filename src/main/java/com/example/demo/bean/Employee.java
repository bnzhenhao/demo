package com.example.demo.bean;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Date;
import java.util.List;
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Date birth;
    private Integer dId;
    private String photo;


    private Department dept;
}

