/*
 * Copyright (c)  2018. houbinbin Inc.
 * fake All rights reserved.
 */

package com.github.houbb.hibernate;


import com.github.houbb.hibernate.model.User;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by houbinbin on 16/6/5.
 */
@Ignore
public class SessionTest {

    @Test
    public void insertUserTest() throws SQLException {
        User user = new User();
        user.setId(3L);
        user.setName("ryo");
        user.setAge(21);
        user.setPassword("123456");
        user.setCreateOn(new Date());
        user.setModifiedOn(new Date());

        new Session().save(user);
    }

    @Test
    public void buildInsertSQLTest() {
        User user = new User();
        user.setId(3L);
        user.setName("ryo");
        user.setAge(21);
        user.setPassword("123456");
        user.setCreateOn(new Date());
        user.setModifiedOn(new Date());
        System.out.println(new Session().buildInsertSQL(user));
    }

}
