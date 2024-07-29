/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate.model;




import com.github.houbb.hibernate.annotations.Column;
import com.github.houbb.hibernate.annotations.Entity;
import com.github.houbb.hibernate.annotations.GenerateValue;
import com.github.houbb.hibernate.annotations.Id;

import java.util.Date;

/**
 * 用户实体类
 * Created by houbinbin on 16/6/5.
 */
@Entity("t_user")
public class User {
    @Id
    @GenerateValue
    private Long    id;
    private String  name;
    private String  password;
    @Column("myAge")
    private Integer age;
    private Date    createOn;
    private Date    modifiedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
